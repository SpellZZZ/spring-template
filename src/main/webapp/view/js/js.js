
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function generateGameList(){
	
	
	
	
	fetch('../def/gameList')
	  .then(response => response.json())
	  .then(data => {
		
		

	    data.forEach(item => {
	    	
	    	
	    	
			const tempID = item.id
			const tempName1 = item.firstPlayer
			const tempName2 = item.secondPlayer
			console.log(tempID + " " + tempName1 +  " "+ tempName2);
			console.log("---------");

			document.getElementById("games").innerHTML += "<p><a href='#' onclick='join("+tempID+")'  >ID:"+ tempID +" First player:" + tempName1 +" Second player:" + tempName2 +" </a></p>";

	    });
	  })
	  .catch(error => {
	    console.error('blad pobierania danych:', error);
	  });
	
	
}



function gameCreator(){
	
	fetch('../def/createGame')
	  .then(response => response.json())
	  .then(item => {
		
	    

			const tempID = item.id
			const tempName1 = item.firstPlayer
			const tempName2 = item.secondPlayer
			
			
			console.log(tempID + " " + tempName1 +  " "+ tempName2);
			
			if(tempName1 != null ){
				console.log("---------Game Created---------");
				document.getElementById("games").innerHTML += "<p><a href='../join?id="+tempID+"'  >ID:"+ tempID +" First player:" + tempName1 +" Second player:" + tempName2 +" </a></p>";
			
				window.location.replace("../wait?id="+tempID+"");
			} else {
				console.log("---------Game Exist---------");
			}
}
	    )
	 
	  .catch(error => {
	    console.error('blad pobierania danych:', error);
	  });
	

}




function join(gameID){
	

	fetch('../def/join?id='+gameID+'')
	  .then(response => response.json())
	  .then(item => {
		
		
			const tempID = item.id
			const tempName1 = item.firstPlayer
			const tempName2 = item.secondPlayer
			console.log("----Joined to-----");
			console.log(tempID + " " + tempName1 +  " "+ tempName2);
			
			window.location.replace("../wait?id="+tempID+"");
			
		})
	  .catch(error => {
	    console.error('blad pobierania danych:', error);
	  });
	
	
	
}
	

	
	
	
