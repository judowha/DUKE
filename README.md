# User Guide

DUKE is a desktop app allows users to record tasks to schedule their work better. The task list will be stored under the same file path as the executable file.

## Quick Start

1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest DUKE.jar from [here](https://github.com/judowha/ip/releases/tag/A-Release).

3. Copy the file to the folder you want to use as the home folder for your DUKE.

## Features:

* ##### View Help: `help`
    Show a help message which will explain all commands in detail.  
    Format: `help`  
    
* ##### Add a ToDO task: `todo`
    Add a task which you want to do but has no specific date or time.  
    Format: `todo TASK`  
    Example:`todo read a book`
  
* ##### Add a Deadline task: `deadline`
    Add a task which need to be done before the deadline. Deadline tasks will be indicated by `[D]` in the task list.  
    Format: `deadline TASK /by  YYYY-MM-DD  HOUR:MINUTE`  
    * the '/' is needed to indicate that the following parts include date and time  
    * the format of date and time is not flexible  
    Example: `deadline return the book /by 2020-10-01 19:00`

* ##### Add an Event task: `event`
    Add a task which need to be done in a specific duration.  
    Format: `event TASK /at  YYYY-MM-DD  STARTHOUR:STARTMINUTE-ENDHOUR:ENDMINUTE`  
    * the '/' is needed to indicate that the following parts include date and time  
    * the format of date and time is not flexible  
    Example: `event return the book /by 2020-10-01 19:00-20:00`
    
* #### Mark a task as done: `done`
    Mark a task as done when the task is completed.  
    Format: `done INDEX`      
    Example: `done 1`  

* #### Delete a task: `delete`
    Delete a task when you want to remove it from the task list.  
    Format: `delete INDEX`     
    Example: `delete 1`  
    
* #### Find a task: `find`
    Find a task in the list.  
    Format: `find KEYWORDS`  
    Example: `find book`  
    
##Command Summary
Action |Format
------ |------
help| `help`
add todo task| `todo TASK`
add deadline task| `deadline TASK /by  YYYY-MM-DD  HOUR:MINUTE`
add event task| `event TASK /at  YYYY-MM-DD  STARTHOUR:STARTMINUTE-ENDHOUR:ENDMINUTE`
done | `done INDEX`
delete | `delete INDEX`
find | `find KEYWORDS`
