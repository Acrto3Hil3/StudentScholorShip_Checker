
/* search button*/

function showSearch() {
    document.getElementById('search-section').style.display = 'block';
}

/*check eligibility*/
function searchEligibility() {
	/* it stores the rollnumber comes from the typed into search box*/
	const rollNumber = document.getElementById('rollNumber').value;

	/* it uses the action="student" url parameter and checks from the data */
	fetch(`student?rollNumber=${rollNumber}`)
	
	/* it convert the result into json format(js object)*/
		.then(response => response.json())
		 .then(data => {
			/* it store the data into resultDIv and then check through if else */
		            const resultDiv = document.getElementById('searchResult');
		            if (data.name) {
		                resultDiv.innerHTML = `<p>Name: ${data.name}</p><p>Eligibility: ${data.eligibility}</p>`;
		            } else {
						resultDiv.innerHTML = '<p>No data found for this roll number.</p>';
		            }
		})
		
		/* using the return so the page not resubmiited(refreshes) again and again  */
		.catch(error => console.error('Error:', error));
		   return false;
}