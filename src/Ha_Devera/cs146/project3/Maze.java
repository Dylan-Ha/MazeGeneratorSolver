package Ha_Devera.cs146.project3;

import java.util.*;

public class Maze {

	Point[][] grid;
	Point currentCell;
	int totalCells;
	int visitedCells;
	int time;
	Stack<Point> cellStack;
	Random randomGen;
	ArrayList<Point> visited;
	
	//@param size the length of one dimension of the maze
	//creates a size*size maze
	public Maze(int size) {
		//grid is set to a new point at bottom right
		grid = new Point[size][size];
		totalCells = size * size;
		cellStack = new Stack<Point>();
		//set seed to 0 so outputs are consistent
		randomGen = new Random(0);
		visited = new ArrayList<Point>();
		//time is set to 0 because nothing has been visited yet, will be incremented during dfs
		time = 0;
	}

	//creates a grid or MxN matrix of the maze
	public void createGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				//creates a point object at each cell in the grid
				grid[i][j] = new Point(i, j);
			}
		}
		
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				//creates/sets all neighbors of all points
				createNeighbors(grid[i][j]);
			}
		}
	}
	
	//sets neighbors of points
	public void createNeighbors(Point p) {
		// if p has a neighbor to the west
		if (p.getX() - 1 >= 0) {
			p.addNeighbor(grid[p.getX() - 1][p.getY()]);
		}
		// if p has a neighbor to the east
		if (p.getX() + 1 < grid.length) {
			p.addNeighbor(grid[p.getX() + 1][p.getY()]);
		}
		// if p has a neighbor to the north
		if (p.getY() - 1 >= 0) {
			p.addNeighbor(grid[p.getX()][p.getY() - 1]);
		}

		// if p has a neighbor to the south
		if (p.getY() + 1 < grid.length) {
			p.addNeighbor(grid[p.getX()][p.getY() + 1]);
		}

	}
	
	//creates the maze in maze format
	public void createMaze() {
		//start at the beginning
		currentCell = grid[0][0];
		visitedCells = 1;
		//as long as the number of visited cells is less than the number of total cells the loop keeps running
		while (visitedCells < totalCells) {
			ArrayList<Point> closedNeighbors = new ArrayList<Point>();
		
			for (Point n : currentCell.getNeighbors()) {
				//adds point n to closed neighbors if point n has walls all around it
				if (n.closed == true) {
					closedNeighbors.add(n);
				}
			}
			
			//runs this code as long as there was closed neighbors
			if (closedNeighbors.size() >= 1) {
				//randomly pick which cell will be opened next
				Point nextCell = closedNeighbors.get(randomGen.nextInt(closedNeighbors.size()));
				//if the cell is to the left,remove this current cell's right wall and next cell's left wall
				if (currentCell.getX() < nextCell.getX()) {
					currentCell.removeEastWall();
					nextCell.removeWestWall();
				} 
				//if the cell is to the right
				else if (currentCell.getX() > nextCell.getX()) {
					currentCell.removeWestWall();
					nextCell.removeEastWall();
				} 
				//if the cell is above
				else if (currentCell.getY() > nextCell.getY()) {
					currentCell.removeNorthWall();
					nextCell.removeSouthWall();
				} 
				//if the cell is below
				else {
					currentCell.removeSouthWall();
					nextCell.removeNorthWall();
				}
				//go to the next cell 
				cellStack.push(currentCell);
				currentCell = nextCell;
				visitedCells++;
			} 
			//pops currentCell from stack if no closed neighbors
			else {
				currentCell = cellStack.pop();
			}
		}
	}

	// display maze with numbers in cells
	public void display1() {
		// open up the starting point at the top left
		grid[0][0].northWall = false;
		// open up the end at the bottom right
		grid[grid.length - 1][grid.length - 1].southWall = false;

		for (int j = 0; j < grid.length; j++) {

			// printing the lines that run horizontal in the maze
			for (int i = 0; i < grid.length; i++) {
				Point cell = grid[i][j];
				// if there is a wall to the north of the cell
				if (cell.northWall == true) {
					// if the cell is not the one all the way to the right
					if (i < grid[0].length - 1) {
						System.out.print("+-");
					}
					// add an extra + to set border
					else {
						System.out.println("+-+");
					}
				}
				// there is no wall to the north of the cell
				else {
					if (i < grid[0].length - 1) {
						System.out.print("+ ");
					}
					// add extra + to set border
					else {
						System.out.println("+ +");
					}
				}
			}
			// printing the lines that run vertical in the maze
			for (int i = 0; i < grid.length; i++) {
				// if there is a wall to the west
				if (grid[i][j].westWall == true) {
					// if the cell is not the one all the way to the right
					if (i < grid[0].length - 1) {
						// if the cell was not visited yet
						if (grid[i][j].order == -1) {
							System.out.print("| ");
						}
						// if the cell was visited
						else {
							System.out.print("|" + grid[i][j].order);
						}
					}
					// the cells to the right gets another | at the end to set the border
					else {
						// if the cell was not visited yet
						if (grid[i][j].order == -1) {
							System.out.println("| |");
						}
						// if the cell was visited
						else {
							System.out.print("|" + grid[i][j].order + "|\n");
						}
					}
				}
				// if there is no wall to the west
				else {
					// if the cell is not the one all the way to the right
					if (i < grid[0].length - 1) {
						// if the cell was not visited yet
						if (grid[i][j].order == -1) {
							System.out.print("  ");
						}
						// if the cell was visited
						else {
							System.out.print(" " + grid[i][j].order);
						}
					}
					// the cells to the right gets another | at the end to set border
					else {
						// if the cell was not visited yet
						if (grid[i][j].order == -1) {
							System.out.println("  |");
						}
						// if the cell was visited
						else {
							System.out.print(" " + grid[i][j].order + "|\n");
						}
					}
				}
			}
		}
		// creating the bottom border of the maze
		for (int i = 0; i < grid[0].length; i++) {
			// if it has a southern wall
			if (grid[i][grid.length - 1].southWall == true) {
				if (i < grid[0].length - 1) {
					System.out.print("+-");
				}
				// if the cell is on the rightmost side
				else {
					System.out.println("+-+");
				}
			}
			// if it has a southern wall
			else {
				if (i < grid[0].length - 1) {
					System.out.print("+ ");
				}
				// if the cell is on the rightmost side
				else {
					System.out.println("+ +");
				}
			}
		}
	}

	// display maze with # in cells
	public void display2() {
		//keeps track of all the parents in the maze
		//the perfect path will only include parents because cells that were visited but were not continued on are not parents
		ArrayList<Point> track = getParents();

		// open up the starting point at the top left
		grid[0][0].northWall = false;
		// open up the end at the bottom right
		grid[grid.length - 1][grid.length - 1].southWall = false;

		for (int j = 0; j < grid.length; j++) {

			// printing the lines that run horizontal in the maze
			for (int i = 0; i < grid.length; i++) {
				Point cell = grid[i][j];
				// if there is a wall to the north of the cell
				if (cell.northWall == true) {
					// if the cell is not the one all the way to the right
					if (i < grid[0].length - 1) {
						System.out.print("+-");
					}
					// add an extra + to set border
					else {
						System.out.println("+-+");
					}
				}
				// there is no wall to the north of the cell
				else {
					if (i < grid[0].length - 1) {
						System.out.print("+ ");
					}
					// add extra + to set border
					else {
						System.out.println("+ +");
					}
				}
			}
			// printing the lines that run vertical in the maze
			for (int i = 0; i < grid.length; i++) {
				// if there is a wall to the west
				if (grid[i][j].westWall == true) {
					// if the cell is not the one all the way to the right
					if (i < grid[0].length - 1) {
						// if the cell was visited
						// if the cell was not visited yet
						if (grid[i][j].order != -1 && track.contains(grid[i][j])) {
							System.out.print("|#");
							
						}
						// if the cell was not visited yet
						else {
							System.out.print("| ");
						}
					}
					// the cells to the right gets another | at the end to set the border
					else {
						// if the cell was visited
						// if the cell was not visited yet
						if (grid[i][j].order != -1 && track.contains(grid[i][j])) {
							System.out.print("|#|\n");
							
						}
						// if the cell was not visited yet
						else {
							System.out.println("| |");
						}
					}
				}
				// if there is no wall to the west
				else {
					// if the cell is not the one all the way to the right
					if (i < grid[0].length - 1) {
						// if the cell was visited
						// if the cell was not visited yet
						if (grid[i][j].order != -1 && track.contains(grid[i][j])) {
							System.out.print(" #");
							
						}
						// if the cell was not visited yet
						else {
							System.out.print("  ");
						}
					}
					// the cells to the right gets another | at the end to set border
					else {
						// if the cell was visited
						// if the cell was not visited yet
						if (grid[i][j].order != -1 && track.contains(grid[i][j])) {
							
							System.out.print(" #|\n");
							
						}
						// if the cell was not visited yet
						else {
							System.out.println("  |");
						}
					}
				}
			}
		}
		// creating the bottom border of the maze
		for (int i = 0; i < grid[0].length; i++) {
			// if it has a southern wall
			if (grid[i][grid.length - 1].southWall == true) {
				if (i < grid[0].length - 1) {
					System.out.print("+-");
				}
				// if the cell is on the rightmost side
				else {
					System.out.println("+-+");
				}
			}
			// if it has a southern wall
			else {
				if (i < grid[0].length - 1) {
					System.out.print("+ ");
				}
				// if the cell is on the rightmost side
				else {
					System.out.println("+ +");
				}
			}
		}
	}

	// the first point
	public Point origin() {
		return grid[0][0];
	}
	
	//solves the maze using breadth first search
	//@param c is the cell bfs is going to start on to solve the maze
	public boolean solveBFS(Point c) {
		// creates a queue for bfs to use
		Queue<Point> explore = new LinkedList<>(); 
		// set the end point of the maze
		Point end = grid[grid.length - 1][grid.length - 1]; 
		// adds to the list of visited nodes
		visited.add(c); 
		// adds to the linked list
		explore.add(c); 
	
		c.order = 0;
		//displays all the steps in bfs
		int counter = 1; 

		//while there is still things to traverse in the queue
		while (!explore.isEmpty()) { 
			// dequeue element
			Point current = explore.remove(); 
			// checks if current point is the end point
			if (current.equals(end)) { 
				
				this.display1();
				return true;
			}

			for (Point neighbor : current.getNeighbors()) {
				// if this point hasn't been visited yet
				if (!visited.contains(neighbor)) {
					//if there is an open wall north
					if (current.northWall == false && current.neighborPosition(neighbor) == Direction.North) {
						//current point is not the starting point
						if (current.getX() != 0 && current.getY() != 0) { 
							//adds neighbor to explore
							explore.add(neighbor);
							//adds neighbor to explore
							visited.add(neighbor); 
							//resets the "order" so that maze is not shifted due to numbers greater than 9
							neighbor.order = counter % 10; 	
							//sets parent of neighbor to current
							neighbor.addParent(current);
							counter++;
							
						}
					}

					// if there is an open wall East
					else if (current.eastWall == false && current.neighborPosition(neighbor) == Direction.East) {
						
						explore.add(neighbor);
						visited.add(neighbor);
						neighbor.order = counter % 10;
						
						neighbor.addParent(current);
					
						counter++;
						
					}

					// if there is an open wall south
					else if (current.southWall == false && current.neighborPosition(neighbor) == Direction.South) {
						
						explore.add(neighbor);
						visited.add(neighbor);
						neighbor.order = counter % 10;
						
						neighbor.addParent(current);
						counter++;
						
					}

					// if there is an open wall West
					else if (current.westWall == false && current.neighborPosition(neighbor) == Direction.West) {
					
						explore.add(neighbor);
						visited.add(neighbor);
						neighbor.order = counter % 10;
						
						neighbor.addParent(current);
						counter++;
						
					}
					
				}
			}

		}
		//if there is no path to be found
		return false; 
	}

	//solves the maze using depth first search
	//@param p is the cell that is dfs is going to start on to solve the maze
	public boolean solveDFS(Point p) {

		//time =0
		//keeps track 
		p.order = 0;
		visited = new ArrayList<Point>();
		visited.add(p);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				boolean dfs = dfsVisit(grid[i][j]);
				if (dfs == true) {
					
					this.display1();
					return true;

				}

			}
		}

		// if you can't find a path
		return false;
	}

	//@param current is the current cell dfs is on
	//dfsVisit works with solveDFS to solve the maze
	public boolean dfsVisit(Point current) {
		//the end of the maze
		Point end = grid[grid.length - 1][grid.length - 1]; 

		//if the current node is equal to the end node; search is completed
		if (current.equals(end)) { 
			return true;
		}

		//looks for neighbors to search if end has not been reached
		for (Point neighbor : current.neighbors) {
			if (!visited.contains(neighbor)) {
				// checks if there is an open wall north of cell
				
				if (current.northWall == false && current.neighborPosition(neighbor) == Direction.North) {
					time++;
					
					neighbor.order = time % 10;
					//sets parent of neighbor as the current cell
					neighbor.addParent(current);
					//adds neighbor to visited arraylist
					visited.add(neighbor);
					// calls dfsVisit on that neighbor if there is
					if (dfsVisit(neighbor)) {
						return true;
					}

				}

				// checks for open wall to the east
				else if (current.eastWall == false && current.neighborPosition(neighbor) == Direction.East) {
					time++;
				
					neighbor.order = time % 10;

					neighbor.addParent(current);
					visited.add(neighbor);
					if (dfsVisit(neighbor)) {
						return true;

					}

				}

				// checks for open wall to the south
				else if (current.southWall == false && current.neighborPosition(neighbor) == Direction.South) {
					time++;
					
					neighbor.order = time % 10;

					neighbor.addParent(current);
					visited.add(neighbor);
					if (dfsVisit(neighbor)) {
						return true;

					}

				}

				// checks for open wall to the west
				else if (current.westWall == false && current.neighborPosition(neighbor) == Direction.West) {
					time++;
				
					neighbor.order = time % 10;

					neighbor.addParent(current);
					visited.add(neighbor);
					if (dfsVisit(neighbor)) {
						return true;

					}

				}

			}

		}

		return false;

	}
	
	//returns an arraylist of parents in the maze
	public ArrayList<Point> getParents()
	{
		ArrayList<Point> track = new ArrayList<Point>();
		Point pt = grid[grid.length - 1][grid.length - 1];
		//adds the first point because it is a parent
		track.add(pt);
		//ignores the first point and adds any parent after that
		while (pt != this.origin()) {
			track.add(pt.parent);
			pt = pt.parent;
		}
		//returns the arraylist
		return track;
	}
	
	//returns a string of the perfect path from start to finish
	public String path() {
		
		ArrayList<Point> track = getParents();
		
		System.out.print("Path:");
		for (int i=track.size()-1;i>=0;i--) {
			System.out.print(track.get(i).toString());
		}
		return "";
	}
	
	//returns the length of the path
	public int pathLength()
	{
		ArrayList<Point> track = getParents();
		
		return track.size();
	}
		

}
