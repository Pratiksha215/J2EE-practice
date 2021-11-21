<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Au Register Forms by Colorlib</title>

    <!-- Icons font CSS-->

    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select3/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/regdatepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/regmain.css" rel="stylesheet" media="all">
</head>

<script>
var subjectObject = {
  "Maharashtra": {
    "Gudi-Padwa": ["Clothes","Jewellery","Pooja-Shahitya","Foot-wear","Beauty-products"],
    "Ganesh-Chaturthi": ["Pooja-Thali","Music Instruments","Decoration","Clothes","Decoration"],
    "Diwali": ["Clothes","Pooja-Shahitya","Sweets","Lights","fire-Crackers"],
    "Shiv-Jayanti": ["Flags","Statue","Clothes","Musical Instruments","Decoration"],
    "Holi": ["Clothes","Colour","Sweets","Pooja-Shahitya","Musical Instruments"],
    "Makar-Sankarati": ["Clothes","Sweets","Kite","Pooja-Shahitya","Jewellery"],
    "KRISHNA JANMASHTMI": ["Musical Instruments","Sweets","Clothes","Dahi-Handi products","Jewellery"],
    "Eid": ["Clothes","Sweets","Decoration","Lighting"],
    "Dusshera": ["Clothes","Pooja Sahitya","Fire-Crackers","Sticks","Decoration products"],
    "Chrismas": ["Clothes","Constume","Sweets","Decoration","Lights"]
    },
"Gujrat":
{
"Dangs Darbar Tribal Festival": ["Clothes","Musical Insruments","Musical Insruments","Jewellery","Beauty-Products","Foot-Wear"],
"Shamlaji Melo": ["Clothes","Pooja-sahitya","Jewellery","Beauty-products","Foot-Wear"],
"Rann Utsav": ["Clothes","Tents","Musical Instrument","Kite","hand-Looms"],
"Kavant Fair": ["Clothes","Musical_insruments","Colour","Foot-wear","Traditional Jewellery"],
"Janmashtami" : ["Musical Instruments","Sweets","Clothes","Dahi-Handi products","Jewellery"]
},
 "Karnataka": {
    "Ganesh-Chaturthi": ["Pooja-Thali","Music Instruments","Decoration products","Clothes","Lights"],
    "Dusshera": ["Clothes","Pooja Sahitya","Fire-Crackers","Sticks","Decoration products"],
    "Diwali": ["Fire-Crackers","Pooja-thali","Rangoli material","Sweet","Lights"],
    "Pongal": ["Poojai Items","Vegetables","Grocery","Lamps","Kolam"]
    },
    "Kerala": {
    "Onam": ["Constume","Statue","Clothes","Pooja-Sahitya","Sweets"],
    "Vishu": ["Statue","Clothes","Pooja-Sahitya","Sweets","Constume"],
    "Deepavali": ["Fire-Crackers","Pooja-thali","Rangoli material","Sweet","Lights"],
    "Chrismas": ["Cloths","Constume","Sweets","Decoration","Lights"]
    }
  }
window.onload = function() {
  var subjectSel = document.getElementById("state");
  var topicSel = document.getElementById("festival");
  var chapterSel = document.getElementById("accessories");
  for (var x in subjectObject) {
    subjectSel.options[subjectSel.options.length] = new Option(x, x);
  }
  subjectSel.onchange = function() {
    //empty Chapters- and Topics- dropdowns
    chapterSel.length = 1;
    topicSel.length = 1;
    //display correct values
    for (var y in subjectObject[this.value]) {
      topicSel.options[topicSel.options.length] = new Option(y, y);
    }
  }
  topicSel.onchange = function() {
    //empty Chapters dropdown
    chapterSel.length = 1;
    //display correct values
    var z = subjectObject[subjectSel.value][this.value];
    for (var i = 0; i < z.length; i++) {
      chapterSel.options[chapterSel.options.length] = new Option(z[i], z[i]);
    }
  }
}
</script>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Add New Product</h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="/saveProduct" enctype = "multipart/form-data">
                       <div class="form-row">
                            <div class="name">Product Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="product_name" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Product Information</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="product_info">
                                </div>
                            </div>
                        </div>
                        
                      <div class="form-row">
                            <div class="name">Product Photo</div>
                            <div class="value">
                                <div class="input-group js-input-file">
                                    <input class="input-file" type="file" name="product_photo" id="file">
                                   <label class="label--file" for="file">Choose file</label>
                                    <span class="input-file__info">No file chosen</span>
                               
                                </div>
                               
                            </div>
                        </div>
                        
                         <div class="form-row">
                            <div class="name">State</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="product_state" id="state">
                                           <option value="" selected="selected">Select State</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                         <div class="form-row">
                            <div class="name">Festival</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="product_festival" id="festival">
    										<option value="" selected="selected">Select Festival</option>
  										</select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                         <div class="form-row">
                            <div class="name">Accessories</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                         <select name="product_accessories" id="accessories">
   												 <option value="" selected="selected">Select Accessories</option>
  										</select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                      
                       
                          <div class="form-row m-b-55">
                            <div class="name">Account</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="product_price">
                                            <label class="label--desc">Price</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="product_quantity">
                                            <label class="label--desc">Quantity</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div>
                            <button class="btn btn--radius-2 btn--green" type="submit">Add Product</button>
                            &emsp;&emsp;
                             <a class="btn btn--radius-2 btn--blue" href="/listProducts">List Products</a>
                             &emsp;
                             <a class="btn btn--radius-2 btn--black" href="/Home">Back</a>
                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select3/select2.min.js"></script>
    <script src="vendor/regdatepicker/moment.min.js"></script>
    <script src="vendor/regdatepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>
     <script src="js/file.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->