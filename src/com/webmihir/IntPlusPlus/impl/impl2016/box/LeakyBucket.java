package com.webmihir.IntPlusPlus.impl.impl2016.box;

import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LeakyBucket {
  private final long _capacity;
  private long _numRequestsPending;
  private long _balanceTicks;
  private long _lastTimeStamp = -1;
  private final long _rateNumerator;
  private final long _rateDenominator;
  private final Clock _clock;

  public LeakyBucket(long capacity, long rate, Duration rateOver, Clock clock) {
    assert capacity > 0;
    assert rate > 0;
    assert rateOver != null && rateOver.toMillis() > 0;
    assert clock != null;

    this._capacity = capacity;
    this._rateNumerator = rate;
    this._rateDenominator = rateOver.toMillis();
    _clock = clock;
  }

  public boolean canServeRequest() {
    long currentTime = _clock.millis();
    long timeElapsed = currentTime - _lastTimeStamp + _balanceTicks;

    if (_lastTimeStamp == -1) {
      _lastTimeStamp = currentTime;
    } else if (timeElapsed >= _rateDenominator) {
      long requestsServed = (timeElapsed / _rateDenominator) * _rateNumerator;

      _numRequestsPending = Math.max(0, _numRequestsPending - requestsServed);
      _balanceTicks = _numRequestsPending > 0 ? (timeElapsed % _capacity) : 0L;
      _lastTimeStamp = currentTime;
    }

    //See if we can serve additional requests now
    if (_numRequestsPending < _capacity) {
      _numRequestsPending ++;
      return true;
    }

    return false;
  }
}
