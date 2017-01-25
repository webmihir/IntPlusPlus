package com.webmihir.IntPlusPlus.impl.impl2016.box;

import java.time.Clock;
import java.time.Duration;


public class LeakyBucket {
  public static class Rate {
    public final long _queries;
    public final Duration _perDuration;

    public Rate(long queries, Duration perDuration) {
      _queries = queries;
      _perDuration = perDuration;
    }
  }

  private final long _capacity;
  private long _pendingRequests;
  private long _balanceTicks;
  private long _lastTimeStamp = -1;
  private final Rate _rate;
  private final Clock _clock;

  public LeakyBucket(long capacity, Rate rate, Clock clock) {
    assert capacity > 0;
    assert rate != null && rate._queries > 0;
    assert rate._perDuration != null && rate._perDuration.toMillis() > 0;
    assert clock != null;

    this._capacity = capacity;
    this._rate = rate;
    _clock = clock;
  }

  public boolean canServeRequest() {
    long currentTime = _clock.millis();
    long timeElapsed = currentTime - _lastTimeStamp + _balanceTicks;

    if (_lastTimeStamp == -1) {
      _lastTimeStamp = currentTime;
    } else if (timeElapsed >= _rate._perDuration.toMillis()) {
      long requestsServed = (timeElapsed / _rate._perDuration.toMillis()) * _rate._queries;

      _pendingRequests = Math.max(0, _pendingRequests - requestsServed);
      _balanceTicks = _pendingRequests > 0 ? (timeElapsed % _capacity) : 0L;
      _lastTimeStamp = currentTime;
    }

    //See if we can serve additional requests now
    if (_pendingRequests < _capacity) {
      _pendingRequests++;
      return true;
    }

    return false;
  }
}
