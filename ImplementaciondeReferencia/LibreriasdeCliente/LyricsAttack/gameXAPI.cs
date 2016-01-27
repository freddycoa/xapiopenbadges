using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class Shot : MonoBehaviour
{
	//	public Transform Hero;// Eje de heroe
	public GameObject Pulpo;
	//	public float HeroSpeed;//velocidad de hero
	//	Vector3 EndPosicion;//la ultima locacion de mouse
	public GameObject Projectile;
	float Fire;
	public float FireTime;

	public		GUIText		cambiacolorGT;


	public string pageText = "";
	void Start(){
		Fire = 0;
	}

	//*Para lanzar projectil
	void Update () {

		Fire -= 1 * Time.deltaTime;
		// Get the current screen position of the mouse from Input
		Vector3 mousePos2D = Input.mousePosition;
		// The Camera's z position sets the how far to push the mouse into 3D
		mousePos2D.z = -Camera.main.transform.position.z;
		// Convert the point from 2D screen space into 3D game world space
		Vector3 mousePos3D = Camera.main.ScreenToWorldPoint (mousePos2D);
		// Move the x position of this Basket to the x position of the Mouse
		Vector3 pos = this.transform.position;
		pos.x = mousePos3D.x;
		//pos.y = mousePos3D.y;
		this.transform.position = pos;

		if (Input.GetMouseButton (0)) {
			if (Fire <= 0) {
				Instantiate (Projectile, transform.position, transform.rotation);
				Fire = FireTime;
			}

		}

	}

	void OnGUI()
	{
		if(GUI.Button(new Rect(50,50,50,50),"Home"))

		{
			Application.LoadLevel("_Escenario0");

		}
	}


	IEnumerator WaitForRequest(WWW www)
	{
		yield return www;
		// check for errors
		if (www.error == null)
		{
			Debug.Log("WWW Ok!: " + www.text);
			Application.ExternalCall("sendTEST()");

		} else {
			Debug.Log("WWW Error: "+ www.error);
		}
	}

	void OnCollisionEnter( Collision coll ) {

		Letras2 letrasScript = Camera.main.GetComponent<Letras2>();


		// GameObject cambiacolorGO = GameObject.Find("Cambiacolor");
		// cambiacolorGT = cambiacolorGO.GetComponent<GUIText>();

		GameObject collidedWith = coll.gameObject;

		//cuando letra falsa choca con el pulpo, llama la funcion de matar todas las letras en la class ApplePicker2(limpiar todas las letras y elimina un corazon)
		if ( collidedWith.tag == "Incorrecto"){


			ApplePicker2 apScript = Camera.main.GetComponent<ApplePicker2>();
			// Call the public AppleDestroyed() method of apScript
			apScript.IncorrectoDestroyed();

		}

		//*cuando letra correcta choca con el pulpo, seguimos pensando...
		else if (collidedWith.tag == "Yes") {
			Destroy (collidedWith);
			letrasScript.success = true;

			string url = "http://localhost:8888/?mbox=ingfcoa@gmail.com&&nameactor=alexiunity";
			// Asignamos la url del Servidor servernodejs y las variables que se enviaran a traves del metodo GET al Servidor xAPI
			WWW www = new WWW(url);
			StartCoroutine(WaitForRequest(www));

			Application.LoadLevel ("_Escenariofinal"); // al cumplir la condicion de aprobación se lee el escenario final
			// de esta forma hacemos el llamado de la funcion XAPI y envio de datos que se cargaran dentro del Badge
		}
	}


}
