package com.poryvai.city;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CityGraphTests {

	@Test
    public void testFindShortestPath() {
        CityGraph cityGraph = new CityGraph();

        cityGraph.addCity("A", 1);
        cityGraph.addCity("B", 2);
        cityGraph.addCity("C", 3);

        cityGraph.addEdge(1,2, 4);
        cityGraph.addEdge(2,3, 6);
        cityGraph.addEdge(1,3, 10);

        assertEquals(10, cityGraph.findShortestPath(1, 3));
        assertEquals(4, cityGraph.findShortestPath(1, 2));

    }

    @Test
    public void testCityNotFound() {
        CityGraph cityGraph = new CityGraph();
        cityGraph.addCity("A", 1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> cityGraph.getCityIndex("D"));
        assertEquals("City not found: D", exception.getMessage());
    }


}
