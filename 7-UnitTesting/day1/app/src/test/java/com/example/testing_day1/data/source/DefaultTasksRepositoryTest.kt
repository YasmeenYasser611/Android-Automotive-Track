package com.example.testing_day1.data.source

import com.example.testing_day1.data.Result
import com.example.testing_day1.data.Task
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test


class DefaultTasksRepositoryTest{


 val task1 = Task("task1", id = "0")
 val task2 = Task("task2")
 val task3 = Task("task3")
 val task4 = Task("task4")


 val localTasks = mutableListOf(task1 , task2)
 val remoteTasks = mutableListOf(task3 , task4)


 lateinit var fakeLocalDataSource :FakeTasksDataSource
 lateinit var fakeRemoteTasksDataSource: FakeTasksDataSource
 lateinit var repository: DefaultTasksRepository

 @Before
 fun setup()
 {
  fakeRemoteTasksDataSource = FakeTasksDataSource(remoteTasks)
  fakeLocalDataSource = FakeTasksDataSource(localTasks)

  repository = DefaultTasksRepository(fakeRemoteTasksDataSource , fakeLocalDataSource)


 }

 @Test
 fun getTasks_withUpdate_returnsRemoteTasks() = runTest {
  val result = repository.getTasks(true) as Result.Success

  assertThat(result.data , `is`(remoteTasks))

 }

 @Test
 fun getTask_TaskID_returnSingleTask() = runTest {
  val result = repository.getTask("0") as Result.Success

  assertThat(result.data , `is`(localTasks[0]))

 }


 }