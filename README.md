# novacyt_test
Read Readings from a Jar File and displays them in Swing.

Program takes a Jar File chosen by a user and invokes a method inside which generates a reading on a blocking thread.
This program uses a SwingWorker to extract it and display it in a JTextArea. Buttons include to start and stop the background
thread and choosing a file.

The class called "Application" contains the Main method for starting the program.

This program was made in an hour, as requested by the specification.


**TASK**
Software Developer Technical Test – Java

The primary applications that Java software developers will be working on are desktop applications,
communicating with PCR devices. This test is used to replicate some of those day-to-day tasks and
offer a platform to evaluate different approaches to software development.

You should limit your time on the task to around 60 minutes, since the discussion is not based
around the quantity of work produced. You should do enough to be able to run the application and
explain your reasoning of the problem and what you would do given more time.

**The task**

You will create a GitHub repository to store your solution.
You will create a Java application that will consume a .jar file named “instrument-sim.jar”
included with this test.

The instrument-sim.jar will have a method called “getReading”. This method will return an
integer value. The method will block the calling thread for a random number of seconds.
You will call the getReading method as often as possible, and output the values to the UI. A
button will be used to start and stop the polling of counts.

You will architect the solution in such a way that the “instrument-sim.jar” may feasibly be
replaced by a .jar file that will call a real instrument, with as little code change as possible.
You may provide short instructions on how we should run the application

