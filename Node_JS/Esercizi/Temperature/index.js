var express =require("express");
var app=express();
var bodyParser=require("body-parser");
app.set('view engine', 'ejs');
var Stazioni=require("./Stazioni").Stazioni
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
var mieStazioni=new Stazioni();

let mediaV=0;
let mediaM=0;
let mediaT=0;
let mediaF=0;
let mediaB=0;
let mediaR=0;
let mediaN=0;
let mediaB2=0; 
let mediaM2=0;


app.listen(1345,function(){
	
	app.get("/",function(req,res){
		var arrayCitta= new Array("Verzuolo","Milano","Torino","Firenze","Bologna","Roma","Napoli","Bari","Messina");
		res.render("home.ejs",{arrayCitta:arrayCitta});
	});
	
	app.post("/salva",function(req,res){
		var max=req.body.massima;
		var min=req.body.minima;
		var citta=req.body.citta;
		mieStazioni.add(max,min,citta);
		mieStazioni.media(mediaV,mediaM,mediaT,mediaF,mediaB,mediaR,mediaN,mediaB2,mediaM2);
		res.sendFile(__dirname+"/sito/salva.html");
	});
		
	app.post("/riepilogo",function(req,res){
		var arrayMedia = new Array(mediaV,mediaM,mediaT,mediaF,mediaB,mediaR,mediaN,mediaM2);
		res.render("riepilogo.ejs",{arrayMedia:arrayMedia,arrayCitta:arrayCitta,stazioni:Stazioni});
	});
	
});