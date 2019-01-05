$(document).ready(function() {
    //console.log( "Ready!" );

      loadData();

}); //CLOSING ON DOCUMENT READY

var section = document.querySelector('#wishesSection');

function loadData() {

    $.get('https://api.myjson.com/bins/v860w', function(data, status) {
        //console.log('Status:', status);
        //console.log('Data:', data);
   		var wishes = data['wishes'];
       	var rand = wishes[Math.floor(Math.random() * wishes.length)];
        var paragraph = document.createElement('p');
        paragraph.textContent = rand.wish;
        $('#wishesSection p').attr('class', 'pl-2');
        section.appendChild(paragraph);
     	
}); 
/*CLOSING "loadData" FUNCTION*/
};