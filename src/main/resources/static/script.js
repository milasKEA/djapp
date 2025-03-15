document.getElementById('djForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission
console.log("fuck")
    const djData = {
        name: document.getElementById('name').value,
        genre: document.getElementById('genre').value,
        availability: document.getElementById('availability').value,
        bpm: document.getElementById('bpm').value
    };

    fetch('/api/djs', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(djData)
    })
        .then(response => {
            if (response.ok) {
                console.log(djData.bio);
                document.getElementById('message').innerText = "DJ added successfully!";
                document.getElementById('djForm').reset(); // Reset the form
            } else {
                throw new Error('Failed to add DJ');
            }
        })
        .catch(error => {
            document.getElementById('message').innerText = error.message;
        });
});