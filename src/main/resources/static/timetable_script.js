// Generate time slots from 13:00 to 08:00
const timeSlots = [];
let hour = 13;

// Generate time slots for the first day
while (hour < 24) {
    timeSlots.push(`${hour.toString().padStart(2, '0')}:00`);
    hour += 2;
}

// Generate time slots for the next day (0:00 to 08:00)
hour = 0;
while (hour < 8) {
    timeSlots.push(`${hour.toString().padStart(2, '0')}:00`);
    hour += 2;
}

// Populate the timetable
const timeSlotsBody = document.getElementById('timeSlotsBody');
timeSlots.forEach(slot => {
    const newRow = timeSlotsBody.insertRow();
    const slotCell = newRow.insertCell(0);
    const djCell = newRow.insertCell(1);
    slotCell.textContent = slot; // Add time slot to the table
    djCell.textContent = ''; // Initially empty; it will be updated later
});

// Function to fill the timetable (to be called from the main page)
function fillTimetable(djData) {
    djData.forEach(dj => {
        const existingRow = Array.from(timeSlotsBody.rows).find(row => row.cells[0].textContent === dj.timeSlot);
        if (existingRow) {
            existingRow.cells[1].textContent = dj.name; // Update the DJ name for the selected time slot
        }
    });
}

// Load existing DJ entries (this assumes you'll fetch existing DJs from your API)
fetch('/api/djs') // Adjust this endpoint according to your backend
    .then(response => response.json())
    .then(data => {
        if (data && Array.isArray(data)) {
            fillTimetable(data);
        }
    });