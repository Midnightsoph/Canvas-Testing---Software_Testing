// ================= LOGIN =================

function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const errorMessage = document.getElementById("error-message");

    if (email === "student@test.com" && password === "test123") {
        localStorage.setItem("loggedIn", "true");
        window.location.href = "dashboard.html";
    } else {
        errorMessage.textContent = "Invalid email or password.";
    }
}

function checkLogin() {
    if (localStorage.getItem("loggedIn") !== "true") {
        window.location.href = "login.html";
    }
}

function logout() {
    localStorage.removeItem("loggedIn");
    window.location.href = "login.html";
}


// ================= ASSIGNMENTS =================

function submitAssignment() {
    const select = document.getElementById("assignmentSelect");
    const input = document.getElementById("assignmentInput");
    const message = document.getElementById("assignmentMessage");

    if (select && select.value === "") {
        message.textContent = "Please select an assignment.";
        return;
    }

    if (input && input.value.trim() === "") {
        message.textContent = "Please enter assignment text.";
        return;
    }

    message.textContent = "Assignment submitted successfully.";
    input.value = "";
}

function markAssignmentComplete() {
    const select = document.getElementById("assignmentSelect");
    const message = document.getElementById("assignmentMessage");

    if (!select || select.value === "") {
        message.textContent = "Please select an assignment first.";
        return;
    }

    message.textContent = select.value + " marked as complete.";
}

function clearAssignmentForm() {
    const select = document.getElementById("assignmentSelect");
    const input = document.getElementById("assignmentInput");
    const message = document.getElementById("assignmentMessage");

    if (select) select.value = "";
    if (input) input.value = "";

    message.textContent = "Assignment form cleared.";
}


// ================= INBOX =================

function sendMessage() {
    const recipient = document.getElementById("recipientInput");
    const subject = document.getElementById("subjectInput");
    const body = document.getElementById("messageInput");
    const status = document.getElementById("sendMessageStatus");

    if (!recipient || !subject || !body || !status) return;

    if (
        recipient.value.trim() === "" ||
        subject.value.trim() === "" ||
        body.value.trim() === ""
    ) {
        status.textContent = "Please fill in all message fields.";
        return;
    }

    status.textContent = "Message sent successfully.";

    recipient.value = "";
    subject.value = "";
    body.value = "";
}

function saveDraftMessage() {
    const recipient = document.getElementById("recipientInput");
    const subject = document.getElementById("subjectInput");
    const body = document.getElementById("messageInput");
    const status = document.getElementById("sendMessageStatus");

    if (!recipient || !subject || !body || !status) return;

    if (
        recipient.value.trim() === "" ||
        subject.value.trim() === "" ||
        body.value.trim() === ""
    ) {
        status.textContent = "Please complete message fields before saving draft.";
        return;
    }

    status.textContent = "Draft saved successfully.";
}

function clearMessageForm() {
    const recipient = document.getElementById("recipientInput");
    const subject = document.getElementById("subjectInput");
    const body = document.getElementById("messageInput");
    const status = document.getElementById("sendMessageStatus");

    if (recipient) recipient.value = "";
    if (subject) subject.value = "";
    if (body) body.value = "";

    if (status) status.textContent = "Message form cleared.";
}


// ================= CALENDAR =================

function addCalendarEvent() {
    const input = document.getElementById("calendarEventInput");
    const list = document.getElementById("calendarEventList");
    const status = document.getElementById("calendarStatus");

    if (!input || !list || !status) return;

    if (input.value.trim() === "") {
        status.textContent = "Please enter an event.";
        return;
    }

    const li = document.createElement("li");
    li.textContent = input.value;
    list.appendChild(li);

    status.textContent = "Event added successfully.";
    input.value = "";
}

function markLastEventImportant() {
    const list = document.getElementById("calendarEventList");
    const status = document.getElementById("calendarStatus");

    if (!list || !status) return;

    const items = list.getElementsByTagName("li");

    if (items.length === 0) {
        status.textContent = "No events available to mark important.";
        return;
    }

    const lastItem = items[items.length - 1];

    if (!lastItem.textContent.startsWith("Important: ")) {
        lastItem.textContent = "Important: " + lastItem.textContent;
    }

    status.textContent = "Last event marked as important.";
}

function removeLastEvent() {
    const list = document.getElementById("calendarEventList");
    const status = document.getElementById("calendarStatus");

    if (!list || !status) return;

    const items = list.getElementsByTagName("li");

    if (items.length === 0) {
        status.textContent = "No events available to remove.";
        return;
    }

    list.removeChild(items[items.length - 1]);
    status.textContent = "Last event removed.";
}

function clearCalendarEvents() {
    const list = document.getElementById("calendarEventList");
    const status = document.getElementById("calendarStatus");

    if (!list || !status) return;

    list.innerHTML = "";
    status.textContent = "Calendar events cleared.";
}


// ================= COURSES =================

function openCourseDetails() {
    const select = document.getElementById("courseSelect");
    const details = document.getElementById("courseDetails");

    if (!select || !details) return;

    if (select.value === "") {
        details.textContent = "Please select a course first.";
        return;
    }

    details.textContent = "Opened details for " + select.value + ".";
}

function favoriteCourse() {
    const select = document.getElementById("courseSelect");
    const message = document.getElementById("favoriteCourseMessage");

    if (!select || !message) return;

    if (select.value === "") {
        message.textContent = "Please select a course to favorite.";
        return;
    }

    message.textContent = select.value + " added to favorites.";
}

function clearCourseSelection() {
    const select = document.getElementById("courseSelect");
    const details = document.getElementById("courseDetails");
    const message = document.getElementById("favoriteCourseMessage");

    if (select) select.value = "";
    if (details) details.textContent = "Course selection cleared.";
    if (message) message.textContent = "";
}


// ================= PROFILE =================

function saveProfile() {
    const name = document.getElementById("editName");
    const email = document.getElementById("editEmail");
    const major = document.getElementById("editMajor");
    const status = document.getElementById("profileStatus");

    const profileName = document.getElementById("profileName");
    const profileEmail = document.getElementById("profileEmail");
    const profileMajor = document.getElementById("profileMajor");

    if (!name || !email || !major || !status) return;

    if (
        name.value.trim() === "" ||
        email.value.trim() === "" ||
        major.value.trim() === ""
    ) {
        status.textContent = "Please complete all profile fields.";
        return;
    }

    if (profileName) profileName.textContent = "Name: " + name.value;
    if (profileEmail) profileEmail.textContent = "Email: " + email.value;
    if (profileMajor) profileMajor.textContent = "Major: " + major.value;

    status.textContent = "Profile updated successfully.";
}