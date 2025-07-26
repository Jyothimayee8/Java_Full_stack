package com.colors;

public class WorkoutImpl {
	//Array
		private WorkOut workouts[];
		
		//constructor
		public WorkoutImpl()
		{
			workouts = new WorkOut[5];
		}

		public void addWorkout(WorkOut workout, int index) {
			//business logic
			workouts[index] = workout;
			
		}

		public WorkOut[] displayWorkouts() {
			return workouts;
		}

}
