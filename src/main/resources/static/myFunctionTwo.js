function myFunction2() {
    // Get the checkbox
    var checkBox = document.getElementById("myCheck");
    // Get the output text
    var button1 = document.getElementById("button1");
  
    // If the checkbox is checked, display the output text
    if (checkBox.checked == false){
      text.style.display = "block";
    } else {
      text.style.display = "none";
    }
  }