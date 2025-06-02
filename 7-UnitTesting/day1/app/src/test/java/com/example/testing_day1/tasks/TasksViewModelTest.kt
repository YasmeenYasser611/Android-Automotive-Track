package com.example.testing_day1.tasks

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testing_day1.data.Task
import com.example.testing_day1.data.source.IDefaultTasksRepository
import getOrAwaitValue
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
 class TasksViewModelTest
 {
  lateinit var repo :IDefaultTasksRepository
  lateinit var tasksViewModel:TasksViewModel

  @Before
  fun starting()
  {
   repo = mockk(relaxed = true)
//   val context = ApplicationProvider.getApplicationContext() as Application
//   tasksViewModel = TasksViewModel(context)

   tasksViewModel = TasksViewModel(repo)
  }

  @Test
  fun addNewTask_newTaskEventsNotNull()
  {

   tasksViewModel.addNewTask()

   val result = tasksViewModel.newTaskEvent.getOrAwaitValue {  }

   assertThat(result , not(nullValue()))
  }

  @Test
  fun setFilter_COMPLETED_TASKS_filteringItemsbyCompletedTask()
  {


   tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)
   var value = tasksViewModel.tasksAddViewVisible.getOrAwaitValue {  }

   assertEquals(value, true)


  }


 }