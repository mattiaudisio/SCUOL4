var moduloExpress = require("express");
var moduloFS = require("fs");

var objExpress = new moduloExpress;
var mioBodyParser = require("body-parser");

objExpress.use(mioBodyParser.json());
objExpress.use(mioBodyParser.urlencoded({extended:true}));


objExpress.listen(1345,function(){

	objExpress.get("/",function (request,response,next){
		var infoItaliano = JSON.parse(moduloFS.readFileSync('fileJSONitaliano.json','utf-8'));
		response.send(infoItaliano);
	});

});
