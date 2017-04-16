name := "distributed-systems-cs171-proj1"

version := "1.0"

scalaVersion := "2.12.1"

// Required to execute the run command in a new process.
// SBT has non-daemon threads of its own, so the worker thread is not stopped unless we specify our application
// to run threads in separate processes
fork:= true
mainClass in (Compile, run) := Some("lamport.Asg")

exportJars := true