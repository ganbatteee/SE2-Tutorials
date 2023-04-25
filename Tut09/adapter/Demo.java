package tuts.tut9.todo.adapter;

import tuts.tut9.todo.adapter.adapter.SquarePegAdapter;
import tuts.tut9.todo.adapter.round.RoundHole;
import tuts.tut9.todo.adapter.round.RoundPeg;
import tuts.tut9.todo.adapter.square.SquarePeg;

/**
 * Somewhere in client code...
 */
public class Demo {
	public static void main(String[] args) {
		//TO-DO: Create 2 instances of RoundHole and RoundPeg with same radius
		RoundHole roundHole = new RoundHole(5);
		RoundPeg roundPeg = new RoundPeg(5);
	 
		//TO-DO: If RoundHole instance can "fits" with RoundPeg instance => show a message
		if (roundHole.fits(roundPeg))
			System.out.println("RoundHole fits with RoundPeg");
	 
		//TO-DO: Create 2 instances of SquarePeg with 2 different widths
		SquarePeg squarePeg1 = new SquarePeg(6);
		SquarePeg squarePeg2 = new SquarePeg(6);

		//Note: You can't make RoundHole instance "fit" with SquarePeg instance
		//Therefore, we need to use Adapter for solving the problem.
		
		//TO-DO: Create 2 corresponding instances of SquarePegAdapter
		SquarePegAdapter squarePegAdapter1 = new SquarePegAdapter(squarePeg1);
		SquarePegAdapter squarePegAdapter2 = new SquarePegAdapter(squarePeg2);

		//TO-DO: If the RoundHole instance can "fits" with "small" RoundPegAdapter instance
		//show a suitable message
		RoundHole roundHole1 = new RoundHole(3);
		 if (roundHole1.fits(squarePegAdapter1))
			 System.out.println("RoundHole instance can \"fits\" with \"small\" RoundPegAdapter instance");
//		System.out.println("Wrong");
	 
		//TO-DO: If the RoundHole instance can not "fits" with "big" RoundPegAdapter instance 
		//show a suitable message
		RoundHole roundHole2 = new RoundHole(3);
		if (roundHole2.fits(squarePegAdapter2))
			System.out.println("RoundHole instance can not \"fits\" with \"big\" RoundPegAdapter instance");
//		System.out.println("Wrong");
	}

}