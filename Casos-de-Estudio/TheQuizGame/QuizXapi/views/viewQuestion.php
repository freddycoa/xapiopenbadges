<?php 

$contadorPreguntas = $_GET["contadorPreguntas"];

$archivo = "../files/questions.txt";
$hand = fopen($archivo,"r") or die("Un error se ha producido."); // Abrimos el archivo modo lectura
$contents = fread($hand,filesize($archivo));
$lineas = explode("\n",$contents); //Separo en lineas	

//count($lineas) // numero de lineas en el archivo de texto

	$arr = array($lineas);
	
	$linearr = explode(", ", $arr[0][$contadorPreguntas]);

	$linearr[0];

?>
                  <div class="panel-heading">Reponder :: <span><b> ¿ <?=$linearr[0]?> ?</b></span></div>
                  <div class="panel-body">
                  	<form id="formRequest" name="formRequest">
<?php
	for($i=1;$i<5;$i++){
?>
						<input type="radio" id="opcionRes" name="opcionRes" value="<?=$linearr[$i]?>"> <?=$linearr[$i]?> </option><br/>

<?php		
	}
?>
	<div style="display:none"><input type="text" name="respuestacorrecta" id="respuestacorrecta" value="<?=$linearr[5]?>" ></div>
					</form>
				</div>


				<!-- <div class="panel panel-primary">
                  <div class="panel-heading">¿The Question its here?<span id="question">555555</span></div>
                  <div class="panel-body" id="questiones">
                    <div class="col-md-8"><strong>Description:</strong> Premio al Primer Nivel de Suma</div>
                    <div class="col-md-8"><strong>Potition:</strong> 3/10</div>
                  </div>
    			</div> -->