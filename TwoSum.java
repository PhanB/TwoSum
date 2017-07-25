package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
 * Bailey Phan
 * July 24, 2017
 * Purpose: tests if any pairing in a list of integers sums to target

 * Inputs: List of integers, followed by a target
 * Output: Determines if any pair of the given integers will sum to the target
 * */
public class TwoSum {

	static int MAX_INT = 2147483647; //used to signal no pair found

	public static void main(String[] args) {
		List<Integer> inputs = new ArrayList<Integer>();

		//list of integers, ended with sum target
		if(args.length < 3){
			System.out.println("Usage: Please input 2+ integer inputs, followed by a target integer.");
			return;
		}

		//parse inputs and store into array (store last one in a variable, as it is our target)
		int target = -999;
		for(int i=0;i<args.length;i++){
			try{
				if(i < args.length-1)
					inputs.add(Integer.parseInt(args[i]));
				else
					target = Integer.parseInt(args[i]);
			}catch(NumberFormatException e){
				System.out.println(e);
				return;
			}
		}

		System.out.println(inputs + " with target: " + target);

		//pass parsed array to function
		int[] solution = twoSum(inputs, target);

		if(solution[0] == MAX_INT && solution[1] == MAX_INT){
			System.out.println("No combination of numbers found to sum to target.");
			return;
		}
		else{
			System.out.println(inputs.get(solution[0]) + " and " + inputs.get(solution[1]) + " sum to " + target + " (positions " + solution[0] + " and " + solution[1] + ")");
		}
		return;

	}


	//returns positions in arraylist of a,b such that a + b = target
	private static int[] twoSum(List<Integer> inputs, int target){
		//uses a hashmap to store what number each input needs to sum to target
		//loops through hashmap to find if a pairing exists so that the pair sums to target
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//<number needed to complete sum, original number's index>
		int[] returnMe = {-999,-999};
		for(int i=0;i<inputs.size();i++){
			if(map.containsKey(inputs.get(i))){
				//return the positions
				returnMe[0] = map.get(inputs.get(i));
				returnMe[1] = i;
				return returnMe;
			}
			else{
				if(!map.containsKey(target - inputs.get(i)))//no duplicates
					map.put(target - inputs.get(i), i);//what this number needs to pair with and its position in arraylist

			}
		}
		//System.out.println(map.keySet());
		int[] failedToFindPair = {MAX_INT,MAX_INT};
		return failedToFindPair;
	}

}
