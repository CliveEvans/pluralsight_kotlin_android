package com.github.cliveevans.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initialiseNotes()
    }

    fun addNote(course: CourseInfo, notTitle: String, noteText: String): Int {
        notes.add(NoteInfo(course, notTitle, noteText))
        return notes.lastIndex
    }

    fun findNote(course: CourseInfo, noteTitle: String, noteText: String): NoteInfo? {
        for (note in notes)
            if (
                course == note.course
                &&
                noteTitle == note.title
                &&
                noteText == note.text
            ) return note
        return null
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course =
            CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "java_lang", title = "Java Fundamentals: The Java Language")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "java_core", title = "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)
    }

    fun initialiseNotes() {
        courses.values.forEach { c: CourseInfo ->
            notes.add(NoteInfo(c, "title for" + c.title, "A note about it"))
        }
    }
}