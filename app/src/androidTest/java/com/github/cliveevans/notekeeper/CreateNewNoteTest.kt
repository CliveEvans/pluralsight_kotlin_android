package com.github.cliveevans.notekeeper

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateNewNoteTest {

    @Rule
    @JvmField
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)

    @Test
    fun createNewNote() {
        val noteTitle = "Test note title"
        val noteText = "This is the Voice of the Mysterons!"

        onView(withId(R.id.fab)).perform(click())

        onView(withId(R.id.textNoteTitle)).perform(typeText(noteTitle))
        onView(withId(R.id.textNoteText)).perform(typeText(noteText))

    }
}