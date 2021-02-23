package Ha_Devera.cs146.project3;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MazeTest {

	int graphSize4 = 4;
	int graphSize5 = 5;
	int graphSize6 = 6;
	int graphSize7 = 7;
	int graphSize8 = 8;
	int graphSize10 = 10;
	int graphSize25 = 25;
	int graphSize50 = 50;

	Maze maze4;
	Maze maze5;
	Maze maze6;
	Maze maze7;
	Maze maze8;
	Maze maze10;
	Maze maze25;
	Maze maze50;
	String expected;

	//creates mazes with sizes with given paramters
	@Before
	public void graphs() {
		maze4 = new Maze(graphSize4);
		maze5 = new Maze(graphSize5);
		maze6 = new Maze(graphSize6);
		maze7 = new Maze(graphSize7);
		maze8 = new Maze(graphSize8);
		maze10 = new Maze(graphSize10);
		maze25 = new Maze(graphSize25);
		maze50 = new Maze(graphSize50);

	}

	//tests that make sure the solutions for bfs and dfs are the same
	@Test
	public void dfsBfsEqualTest() throws IOException {
		maze4.createGrid();
		maze4.createMaze();
		assertEquals(maze4.solveBFS(maze4.origin()), maze4.solveDFS(maze4.origin()));

		maze5.createGrid();
		maze5.createMaze();
		assertEquals(maze5.solveBFS(maze5.origin()), maze5.solveDFS(maze5.origin()));
		
		maze6.createGrid();
		maze6.createMaze();
		assertEquals(maze6.solveBFS(maze6.origin()), maze6.solveDFS(maze6.origin()));
		
		maze7.createGrid();
		maze7.createMaze();
		assertEquals(maze7.solveBFS(maze7.origin()), maze7.solveDFS(maze7.origin()));
		
		maze8.createGrid();
		maze8.createMaze();
		assertEquals(maze8.solveBFS(maze8.origin()), maze8.solveDFS(maze8.origin()));

		maze10.createGrid();
		maze10.createMaze();
		assertEquals(maze10.solveBFS(maze10.origin()), maze10.solveDFS(maze10.origin()));

		maze25.createGrid();
		maze25.createMaze();
		assertEquals(maze25.solveBFS(maze25.origin()), maze25.solveDFS(maze25.origin()));

		maze50.createGrid();
		maze50.createMaze();
		assertEquals(maze50.solveBFS(maze50.origin()), maze50.solveDFS(maze50.origin()));

		System.out.println("=================");
		System.out.println("Program Completed");
		System.out.println("=================\n");
	}

	// tests to make sure all the methods run correctly and maze is correct
	@Test
	public void Test() throws IOException {
		/*
		 * Size 4
		 */
		// BFS test
		System.out.println("Graph Size: " + graphSize4);
		maze4.createGrid();
		maze4.createMaze();
		System.out.println("Empty Maze:");
		maze4.display1();
		System.out.println("\nBFS:");
		maze4.solveBFS(maze4.origin());
		System.out.println("");
		maze4.display2();
		System.out.println("Number of cells visited: " + maze4.visited.size());
		System.out.println("Length of Path: " + maze4.pathLength());
		System.out.println(maze4.path());

		// DFS test
		System.out.println("\nDFS:");
		maze4.solveDFS(maze4.origin());
		System.out.println("");
		maze4.display2();
		System.out.println("Number of cells visited: " + maze4.visited.size());
		System.out.println("Path length: " + maze4.pathLength());
		System.out.println(maze4.path());
		System.out.println("=================");
		System.out.println("Program Completed");
		System.out.println("=================\n");

		/*
		 * Size 5
		 */
		// BFS test
		System.out.println("Graph Size: " + graphSize5);
		maze5.createGrid();
		maze5.createMaze();
		System.out.println("Empty Maze:");
		maze5.display1();
		System.out.println("\nBFS:");
		maze5.solveBFS(maze5.origin());
		System.out.println("");
		maze5.display2();
		System.out.println("Number of cells visited: " + maze5.visited.size());
		System.out.println("Path length: " + maze5.pathLength());
		System.out.println(maze5.path());

		// DFS test
		System.out.println("\nDFS:");
		maze5.solveDFS(maze5.origin());
		System.out.println("");
		maze5.display2();
		System.out.println("Number of cells visited: " + maze5.visited.size());
		System.out.println("Path length: " + maze5.pathLength());
		System.out.println(maze5.path());
		System.out.println("=================");
		System.out.println("Program Completed");
		System.out.println("=================\n");		
		
		//size 6 
		//bfs test
		System.out.println("Graph Size: " + graphSize6);
		maze6.createGrid();
		maze6.createMaze();
		System.out.println("Empty Maze:");
		maze6.display1();
		System.out.println("\nBFS:");
		maze6.solveBFS(maze6.origin());
		System.out.println("");
		maze6.display2();
		System.out.println("Number of cells visited: " + maze6.visited.size());
		System.out.println("Path length: " + maze6.pathLength());
		System.out.println(maze6.path());

		// DFS test
		System.out.println("\nDFS:");
		maze5.solveDFS(maze6.origin());
		System.out.println("");
		maze5.display2();
		System.out.println("Number of cells visited: " + maze6.visited.size());
		System.out.println("Path length: " + maze6.pathLength());
		System.out.println(maze6.path());
		System.out.println("=================");
		System.out.println("Program Completed");
		System.out.println("=================\n");
		
		/*
		 * Size 7
		 */
		// BFS test
		System.out.println("Graph Size: " + graphSize7);
		maze7.createGrid();
		maze7.createMaze();
		System.out.println("Empty Maze:");
		maze7.display1();
		System.out.println("\nBFS:");
		maze7.solveBFS(maze7.origin());
		System.out.println("");
		maze7.display2();
		System.out.println("Number of cells visited: " + maze7.visited.size());
		System.out.println("Path length: " + maze7.pathLength());
		System.out.println(maze7.path());

		// DFS test
		System.out.println("\nDFS:");
		maze7.solveDFS(maze5.origin());
		System.out.println("");
		maze7.display2();
		System.out.println("Number of cells visited: " + maze7.visited.size());
		System.out.println("Path length: " + maze7.pathLength());
		System.out.println(maze7.path());
		System.out.println("=================");
		System.out.println("Program Completed");
		System.out.println("=================\n");
		
		/*
		 * Size 8
		 */
		// BFS test
		System.out.println("Graph Size: " + graphSize8);
		maze8.createGrid();
		maze8.createMaze();
		System.out.println("Empty Maze:");
		maze8.display1();
		System.out.println("\nBFS:");
		maze5.solveBFS(maze8.origin());
		System.out.println("");
		maze5.display2();
		System.out.println("Number of cells visited: " + maze8.visited.size());
		System.out.println("Path length: " + maze5.pathLength());
		System.out.println(maze8.path());

		// DFS test
		System.out.println("\nDFS:");
		maze8.solveDFS(maze8.origin());
		System.out.println("");
		maze8.display2();
		System.out.println("Number of cells visited: " + maze8.visited.size());
		System.out.println("Path length: " + maze8.pathLength());
		System.out.println(maze8.path());
		System.out.println("=================");
		System.out.println("Program Completed");
		System.out.println("=================\n");
		/*
		 * Size 10
		 */
		// BFS test
		System.out.println("Graph Size: " + graphSize10);
		maze10.createGrid();
		maze10.createMaze();
		System.out.println("Empty Maze:");
		maze10.display1();
		System.out.println("\nBFS:");
		maze10.solveBFS(maze10.origin());
		System.out.println("");
		maze10.display2();
		System.out.println("Number of cells visited: " + maze10.visited.size());
		System.out.println("Path length: " + maze10.pathLength());
		System.out.println(maze10.path());

		// DFS test
		System.out.println("\nDFS:");
		maze10.solveDFS(maze10.origin());
		System.out.println("");
		maze10.display2();
		System.out.println("Number of cells visited: " + maze10.visited.size());
		System.out.println("Path length: " + maze10.pathLength());
		System.out.println(maze10.path());
		System.out.println("=================");
		System.out.println("Program Completed");
		System.out.println("=================\n");

	}

	//checks running time for differnet input sizes
		@Test
		public void runTest() {
			long a, b, c, d, e;

			a = System.nanoTime();
			maze4.createGrid();
			b = System.nanoTime();
			maze4.createMaze();
			c = System.nanoTime();
			maze4.solveBFS(maze4.origin());
			d = System.nanoTime();
			maze4.solveDFS(maze4.origin());
			e = System.nanoTime();

			long ba = b - a;
			long cb = c - b;
			long dc = d - c;
			long ed = e - d;

			System.out.println("Generate grid time: " + ba);
			System.out.println("Generate maze time: " + cb);
			System.out.println("Solve BFS time: " + dc);
			System.out.println("Solve DFS time: " + ed);

			a = System.nanoTime();
			maze5.createGrid();
			b = System.nanoTime();
			maze5.createMaze();
			c = System.nanoTime();
			maze5.solveBFS(maze5.origin());
			d = System.nanoTime();
			maze5.solveDFS(maze5.origin());
			e = System.nanoTime();

			ba = b - a;
			cb = c - b;
			dc = d - c;
			ed = e - d;

			System.out.println("Generate grid time: " + ba);
			System.out.println("Generate maze time: " + cb);
			System.out.println("Solve BFS time: " + dc);
			System.out.println("Solve DFS time: " + ed);

			a = System.nanoTime();
			maze6.createGrid();
			b = System.nanoTime();
			maze6.createMaze();
			c = System.nanoTime();
			maze6.solveBFS(maze6.origin());
			d = System.nanoTime();
			maze6.solveDFS(maze6.origin());
			e = System.nanoTime();

			ba = b - a;
			cb = c - b;
			dc = d - c;
			ed = e - d;

			System.out.println("Generate grid time: " + ba);
			System.out.println("Generate maze time: " + cb);
			System.out.println("Solve BFS time: " + dc);
			System.out.println("Solve DFS time: " + ed);

			a = System.nanoTime();
			maze7.createGrid();
			b = System.nanoTime();
			maze7.createMaze();
			c = System.nanoTime();
			maze7.solveBFS(maze7.origin());
			d = System.nanoTime();
			maze7.solveDFS(maze7.origin());
			e = System.nanoTime();

			ba = b - a;
			cb = c - b;
			dc = d - c;
			ed = e - d;

			System.out.println("Generate grid time: " + ba);
			System.out.println("Generate maze time: " + cb);
			System.out.println("Solve BFS time: " + dc);
			System.out.println("Solve DFS time: " + ed);

			a = System.nanoTime();
			maze8.createGrid();
			b = System.nanoTime();
			maze8.createMaze();
			c = System.nanoTime();
			maze8.solveBFS(maze8.origin());
			d = System.nanoTime();
			maze8.solveDFS(maze8.origin());
			e = System.nanoTime();

			ba = b - a;
			cb = c - b;
			dc = d - c;
			ed = e - d;

			System.out.println("Generate grid time: " + ba);
			System.out.println("Generate maze time: " + cb);
			System.out.println("Solve BFS time: " + dc);
			System.out.println("Solve DFS time: " + ed);

			a = System.nanoTime();
			maze10.createGrid();
			b = System.nanoTime();
			maze10.createMaze();
			c = System.nanoTime();
			maze10.solveBFS(maze10.origin());
			d = System.nanoTime();
			maze10.solveDFS(maze10.origin());
			e = System.nanoTime();

			ba = b - a;
			cb = c - b;
			dc = d - c;
			ed = e - d;

			System.out.println("Generate grid time: " + ba);
			System.out.println("Generate maze time: " + cb);
			System.out.println("Solve BFS time: " + dc);
			System.out.println("Solve DFS time: " + ed);

			a = System.nanoTime();
			maze25.createGrid();
			b = System.nanoTime();
			maze25.createMaze();
			c = System.nanoTime();
			maze25.solveBFS(maze25.origin());
			d = System.nanoTime();
			maze25.solveDFS(maze25.origin());
			e = System.nanoTime();

			ba = b - a;
			cb = c - b;
			dc = d - c;
			ed = e - d;

			System.out.println("Generate grid time: " + ba);
			System.out.println("Generate maze time: " + cb);
			System.out.println("Solve BFS time: " + dc);
			System.out.println("Solve DFS time: " + ed);
			
			System.out.println("=================");
			System.out.println("Program Completed");
			System.out.println("=================\n");
		}

}
