package chapter8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Imagine you have a call center with three levels of employees: respondent,
 * manager, and director. An incoming call must be first allocated to a
 * respondent who is free. If the respondent can't handle the call, he or she
 * must escalate to call to a manager. If the manager is not free or not able to
 * handle it, then the call should be escalated to a director. Design the
 * classes and data structure for this problem. Implemented a method
 * dispathchCall() which assigns a call the the first available employee.
 * 
 * @author boyxgc
 * 
 */
public class Q2 {
	public abstract class Employee {
		protected String id;
		protected String name;
		protected boolean isAvailable;
		protected Call currentCall;

		public Employee(String _id, String _name) {
			id = _id;
			name = _name;
			isAvailable = true;
		}

		public boolean isAvailable() {
			return isAvailable;
		}

		public void setAvailability(boolean isFree) {
			isAvailable = isFree;
		}

		public void receieveCall(Call call) {
			currentCall = call;
			setAvailability(false);
		}

		public void compeletCurrentCall() {
			currentCall = null;
			setAvailability(true);
		}
	}

	public class Respondent extends Employee {
		public Respondent(String _id, String _name) {
			super(_id, _name);
		}
	}

	public class Manager extends Employee {
		public Manager(String _id, String _name) {
			super(_id, _name);
		}
	}

	public class Director extends Employee {
		public Director(String _id, String _name) {
			super(_id, _name);
		}
	}

	public class Caller {
		private String name;

		public Caller(String _name) {
			name = _name;
		}

		public String getCallerName() {
			return name;
		}
	}

	public class Call {
		private Caller caller;
		private Employee handler;

		public Call(Caller _caller) {
			caller = _caller;
		}

		public void setHandler(Employee _handler) {
			handler = _handler;
		}

		public Employee getHandler() {
			return handler;
		}

		public Caller getCaller() {
			return caller;
		}

	}

	public class CallCenter {
		private Queue<Director> directors;
		private Queue<Manager> managers;
		private Queue<Respondent> respondents;

		private Queue<Call> incomingCalls;

		public CallCenter() {
			directors = new LinkedList<Director>();
			managers = new LinkedList<Manager>();
			respondents = new LinkedList<Respondent>();
			incomingCalls = new LinkedList<Call>();
		}

		public void addEmployee(Employee newHire) {
			if (newHire instanceof Respondent) {
				respondents.add((Respondent) newHire);
			} else if (newHire instanceof Manager) {
				managers.add((Manager) newHire);
			} else if (newHire instanceof Director) {
				directors.add((Director) newHire);
			}
		}

		public void addToCallQueue(Call call) {
			incomingCalls.add(call);
		}

		public void dispatchCall(Caller caller) {
			Call call = new Call(caller);
			Employee handler = getNextFree();

			if (handler == null) {
				addToCallQueue(call);
			} else {
				handler.receieveCall(call);
			}
		}

		private Employee getNextFree() {
			/* get next free from 3 employee queues */
			return null;
		}
	}

}