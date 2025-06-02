package com.example.testing_day1.statistics

import com.example.testing_day1.data.Task
import junit.framework.TestCase.assertEquals
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.internal.matchers.Null

class StatisticsUtilsTest
{
 @Test
 fun getActiveAndCompletedStatus_ListWithActiveAndCompleted_50Active50Completed()
 {

  //given
  val tasks = listOf(Task(isCompleted = true) , Task(isCompleted=false))

  //when
  val result = getActiveAndCompletedStats(tasks)

  //then
  assertEquals(50f , result.activeTasksPercent)
//  assertThat(result.completedTasksPercent , 'is' (50f))

 }

 @Test
 fun getActiveAndCompletedStatus_ListWithActive_100Active()
 {

  //given
  val tasks = listOf(Task(isCompleted = false) , Task(isCompleted=false))

  //when
  val result = getActiveAndCompletedStats(tasks)

  //then
  assertEquals(100f , result.activeTasksPercent)
  assertEquals(0f , result.completedTasksPercent)
//  assertThat(result.completedTasksPercent , 'is' (0f))

 }

 @Test
 fun getActiveAndCompletedStatus_ListWithActive_60Active40completed()
 {

  //given
  val tasks = listOf(Task(isCompleted = false) , Task(isCompleted=false),Task(isCompleted = false)  , Task(isCompleted = true) , Task(isCompleted = true) )

  //when
  val result = getActiveAndCompletedStats(tasks)

  //then
  assertEquals(60f , result.activeTasksPercent)
  assertEquals(40f , result.completedTasksPercent)
//  assertThat(result.completedTasksPercent , 'is' (40f))

 }

 @Test
 fun getActiveAndCompletedStatus_ListWithActive_EmptyList()
 {

  //given
  val tasks = emptyList<Task>()

  //when
  val result = getActiveAndCompletedStats(tasks)

  //then
  assertEquals(0f , result.activeTasksPercent)
  assertEquals(0f , result.completedTasksPercent)
//  assertThat(result.completedTasksPercent , 'is' (0f))

 }

 @Test
 fun getActiveAndCompletedStatus_ListWithActive_NullList()
 {

  //given:
  val tasks : List<Task>? = null


  //when
  val result = getActiveAndCompletedStats(tasks)

  //then
  assertEquals(0f , result.activeTasksPercent)
  assertEquals(0f , result.completedTasksPercent)
//  assertThat(result.completedTasksPercent , 'is' (0f))

 }
}