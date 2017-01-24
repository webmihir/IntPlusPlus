package com.webmihir.IntPlusPlus.impl.impl2016.box;

import java.time.Clock;


public class LeakyBucket {
  private final long _capacity;
  private long _numRequestsPending;
  private long _lastTimeStamp;
  private final int _rateNumerator;
  private final int _rateDenominator;
  private final Clock _clock;

  public LeakyBucket(long capacity, int rateNumerator, int rateDenominator, Clock clock) {
    assert capacity > 0;
    assert rateDenominator > 0;
    assert rateNumerator > 0;
    assert clock != null;

    this._capacity = capacity;
    this._rateDenominator = rateDenominator;
    this._rateNumerator = rateNumerator;
    _clock = clock;
  }

  public boolean canServeRequest() {
    long currentTime = _clock.millis();
    long timeElapsed = currentTime - _lastTimeStamp;

    //Remove served requests from the pending bucket
    if (timeElapsed >= _rateDenominator) {
      long requestsServed = (timeElapsed / _rateDenominator) * _rateNumerator;
      _numRequestsPending = Math.max(0, _numRequestsPending - requestsServed);
      _lastTimeStamp = currentTime;
      System.out.println("Setting lastTimeStamp = " + _lastTimeStamp + " at " + currentTime);
    }

    //See if we can serve additional requests now
    if (_numRequestsPending < _capacity) {
      _numRequestsPending ++;
      return true;
    }

    return false;
  }
}
