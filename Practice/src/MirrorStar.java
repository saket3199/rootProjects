
public class MirrorStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows=7;
		
		 for (int i= rows; i>= 1; i--)

		    {

		    for (int j=rows; j>i;j--)

		    {

		    System.out.print(" ");

		    }

		    for (int k=1;k<=i;k++)

		    {

		    System.out.print("*");

		    }

		    System.out.println("");

		    }

	}

}
