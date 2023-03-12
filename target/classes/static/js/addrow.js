let count=3;
function addRow() {

  var tableBody = document.getElementById("tableBody");
  var newRow = document.createElement("tr");
  var newCell = document.createElement("td");
      newCell.innerHTML=++count;
  var newInput = document.createElement("input");
  newRow.appendChild(newCell);
  for (var i = 0; i < 2; i++) {
    var newCell = document.createElement("td");
    var newInput = document.createElement("input");
    newRow.appendChild(newCell);
    newCell.appendChild(newInput);
    newInput.setAttribute('name',count+"_"+i);
    newInput.setAttribute('type',"text");
    newInput.setAttribute('class',"input-td");
  }
  tableBody.appendChild(newRow);
} 