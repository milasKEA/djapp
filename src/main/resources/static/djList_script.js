async function fetchDJs() {
    try {
        const response = await fetch('/api/djs/allDjs');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const djs = await response.json();
        const djList = document.getElementById('djList');

        // Clear existing list items if any
        djList.innerHTML = '';

        djs.forEach(dj => {
            const listItem = document.createElement('li');
            listItem.classList.add('djList_li'); // Add the class to each list item
            listItem.innerHTML = `<strong>${dj.name}</strong> `; // Display name and bio
            djList.appendChild(listItem);
        });
    } catch (error) {
        console.error('Error fetching DJs:', error);
    }
}

document.addEventListener('DOMContentLoaded', fetchDJs);