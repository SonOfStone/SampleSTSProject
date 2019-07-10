/*Need to change fields and add in date */

function get(url, element) {
	let div = document.getElementById(element);

	let xhr = new XMLHttpRequest(); // Ready State 0

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			
			let requests = JSON.parse(xhr.responseText);
			console.log(requests);
			outputHTML ='<div class="row justify-content-center">' +
							'<table class="table table-striped">' +
								'<thead>' + 
								    '<tr>' +
								      '<th scope="col">Submit Date</th>' +
								      '<th scope="col">Event Name</th>' +
								      '<th scope="col">Event Description</th>' +
								      '<th scope="col">Justification</th>' +
								      '<th scope="col">Cost</th>' +
								      '<th scope="col">Status</th>' +
								    '</tr>' + 
								 '</thead>';
			for(let i = 0; i < requests.length; i++){
				outputHTML += `<tbody>
								 <tr>
								 	<td>` + requests[i]["timeSubmitted"].substring(0, 10) + `</td>
								 	<td>` + requests[i]["eventName"] + `</td>
								 	<td>` + requests[i]["description"] + `</td>
								 	<td>` + requests[i]["justification"] + `</td>
								 	<td>$` + requests[i]["cost"].toFixed(2) + `</td>`;
								 	
								 	if(requests[i]["stage"] == 0){
								 		outputHTML += `<td>Waiting on Supervisor</td>`
								 	}else if(requests[i]["stage"] == 1){
								 		outputHTML += `<td>Waiting on Department Head</td>`
								 	}else if(requests[i]["stage"] == 2){
								 		outputHTML += `<td>Wating on BenCo</td>`
								 	}else if(requests[i]["stage"] == 3){
								 		outputHTML += `<td>Approved</td>`
								 	}
								outputHTML += ` </tr>
							   </tbody>`
			}
			outputHTML += '</div>';
			div.innerHTML = outputHTML
			
		}
	}

	xhr.open("GET", url);
	xhr.send();
}

window.onload = function() {
	let url = "/Reimbursement/api/myforms";
	this.get(url, "content");
}
