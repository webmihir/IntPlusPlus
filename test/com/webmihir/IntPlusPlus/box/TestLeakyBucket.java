package com.webmihir.IntPlusPlus.box;

import com.webmihir.IntPlusPlus.impl.impl2016.box.LeakyBucket;
import java.time.Clock;
import static org.mockito.Mockito.*;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLeakyBucket {
  private final Clock _mockClock = mock(Clock.class);

  @BeforeTest
  public void beforeTest() {
    reset(_mockClock);
  }
  @Test
  public void testRateLimiter() throws Exception {
    //Create a rate limiter for 1 requests per 3 millis
    LeakyBucket testClass = new LeakyBucket(3L, 1L, Duration.ofMillis(3L), _mockClock);

    //t = 1, send 3 requests
    when(_mockClock.millis()).thenReturn(1L);
    for (int i = 0; i < 3; i++) Assert.assertTrue(testClass.canServeRequest()); //3 requests in first second

    //t = 2, send 1 request
    when(_mockClock.millis()).thenReturn(2L);
    Assert.assertFalse(testClass.canServeRequest());

    //t = 3, send 1 request
    when(_mockClock.millis()).thenReturn(3L);
    Assert.assertFalse(testClass.canServeRequest());

    //t = 4, send 1 request - should pass, 2nd request should fail
    when(_mockClock.millis()).thenReturn(4L);
    Assert.assertTrue(testClass.canServeRequest());
    Assert.assertFalse(testClass.canServeRequest()); //2nd request should fail

    //t = 5, send 1 request
    when(_mockClock.millis()).thenReturn(5L);
    Assert.assertFalse(testClass.canServeRequest());

    //t = 6, send 1 request, should pass
    when(_mockClock.millis()).thenReturn(6L);
    Assert.assertFalse(testClass.canServeRequest());
  }

  @Test
  public void testRateLimiter2() throws Exception {
    //Create a rate limiter for 1 requests per 3 millis
    LeakyBucket testClass = new LeakyBucket(3L, 1L, Duration.ofMillis(3L), _mockClock);

    //t = 1, send 3 requests
    when(_mockClock.millis()).thenReturn(1L);
    for (int i = 0; i < 3; i++) Assert.assertTrue(testClass.canServeRequest()); //3 requests in first second

    //t = 2, send 1 request
    when(_mockClock.millis()).thenReturn(2L);
    Assert.assertFalse(testClass.canServeRequest());

    //t = 5, send 1 request -- should pass, set balanceTicks to 1
    when(_mockClock.millis()).thenReturn(5L);
    Assert.assertTrue(testClass.canServeRequest());

    //t = 7, send 1 request -- should pass since balanceTicks was 1
    when(_mockClock.millis()).thenReturn(7L);
    Assert.assertTrue(testClass.canServeRequest());
  }
}
