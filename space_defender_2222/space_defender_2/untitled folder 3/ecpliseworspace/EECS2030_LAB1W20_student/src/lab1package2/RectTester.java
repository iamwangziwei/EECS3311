package lab1package2;

import static org.junit.Assert.*;

import org.junit.Test;



	import org.junit.After;

	import org.junit.Before;
	public class RectTester {

		
	        Rectangle r;
			Rectangle[] rList=new Rectangle[5];

			@Before
			// Will be performed before each test.
			public void testSetup()
			{
				System.out.println("Setup for test complete.");
			}

			@After
			// Will be performed after each test.
			public void testComplete()
			{
				System.out.println("Test complete.");
			}

			@Test
			public void test1()
			{
				// Can be run when reader methods and default 
				// constructor are complete.
				r=new Rectangle();
				try
				{
					assertTrue("Test 1: Default values are wrong.", 
						r.getH()==0 && r.getW()==0);
					System.out.println("Test 1 completed successfully.");
				}
				catch (AssertionError e)
				{
					System.out.println(e.getMessage());
				}
			}

			@Test
			public void test2()
			{
				// After area reader is written.
				r=new Rectangle();
				try
				{
					assertTrue("Test 2: Default values are wrong.", 
						r.getH()==0 && r.getW()==0 && r.getA()==0);
					System.out.println("Test 2 completed successfully.");
				}
				catch (AssertionError e)
				{
					System.out.println(e.getMessage());
				}
			}


			
			@Test
			public void test3()
			{
				// After second constructor is written.
				r=new Rectangle();
				try
				{
					r=new Rectangle(10,20);
					assertTrue("Test 3: Initial values are wrong.", 
						r.getH()==10 && r.getW()==20 && r.getA()==200);
					System.out.println("Test 3 completed successfully.");
				}
				catch (AssertionError e)
				{
					System.out.println(e.getMessage());
				}
			}

			@Test
			public void test4()
			{
				// After second constructor is written.
				r=new Rectangle();
				try
				{
					for (int i=0;i<5;i++)
					{
						rList[i] = new Rectangle(2*i,3*i);
						assertTrue("Test 4: Initial values are wrong.", 
							rList[i].getH()==2*i && 
							rList[i].getW()==3*i && 
							rList[i].getA()==6*i*i);
					}
					System.out.println("Test 4 completed successfully.");
				}
				catch (AssertionError e)
				{
					System.out.println(e.getMessage());
				}
			}

			@Test
			public void test5()
			{
				// After writers are written.
				r=new Rectangle();
				try
				{
					for (int i=0;i<5;i++)
					{
						rList[i] = new Rectangle(2*i,3*i);
						rList[i].setH(11*i);
						rList[i].setW(7*i);
						assertTrue("Test 5: Modified values are wrong.", 
							rList[i].getH()==11*i && 
							rList[i].getW()==7*i && 
							rList[i].getA()==77*i*i);
					}
					System.out.println("Test 5 completed successfully.");
				}
				catch (AssertionError e)
				{
					System.out.println(e.getMessage());
				}
			}

			@Test
			public void test6()
			{
				// toString test.
				r=new Rectangle();
				try
				{
					for (int i=0;i<5;i++)
					{
						rList[i] = new Rectangle(2*i,3*i);
						rList[i].setH(11*i);
						rList[i].setW(7*i);
						assertTrue("Test 6: Modified values are wrong.", 
							rList[i].getH()==11*i && 
							rList[i].getW()==7*i &&
							rList[i].getA()==77*i*i);
						System.out.println(rList[i]);
					}
					System.out.println("Test 6 completed successfully.");
				}
				catch (AssertionError e)
				{
					System.out.println(e.getMessage());
				}
			}

}
