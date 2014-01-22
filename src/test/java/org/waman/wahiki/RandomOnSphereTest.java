package org.waman.wahiki;

import org.junit.Test;
import org.waman.washiki.RandomOnSphere;

public class RandomOnSphereTest {

    @Test
    public void testInstantiation(){
        RandomOnSphere random = new RandomOnSphere(Math::random);
    }
}
