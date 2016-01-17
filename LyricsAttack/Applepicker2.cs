using UnityEngine;
using System.Collections;
using System.Collections.Generic;
public class ApplePicker2 : MonoBehaviour {
	public GameObject Pulpo;
	public int numHearts = 3;
	public GameObject heartPrefab;
	public float heartlocationX = -20f;
	public float heartSpacingX = 2f;
	public List<GameObject> heartList;
	public bool NoHayVida =false;

//建造三颗心
	//*construir tres corazones
	void Start () {
		heartList = new List<GameObject>();
		for (int i=0; i<numHearts; i++) {
			GameObject tHeartGO = Instantiate( heartPrefab ) as GameObject;
			Vector3 pos = Vector3.zero;
			pos.y = 30f;
			pos.x = heartlocationX + ( heartSpacingX * i );
			tHeartGO.transform.position = pos;
			heartList.Add( tHeartGO );
		}

		
	}


	public void Update(){
/*		InvokeRepeating("h1Destroyed", 10f, 2f);
		InvokeRepeating("h2Destroyed", 14f, 2f);
		InvokeRepeating("h3Destroyed", 16f, 2f);
		if(NoHayVida){
			Application.LoadLevel ("_Escenario0");
		}
*/		}






	//销毁所有的苹果，并减去一颗心（应在苹果出下线,小章鱼被消灭的,不小心灭掉正确答案。。情况下）
	//mata todas las letras, y mata una corazon(en el caso de las letras esta debajo de el pulpo, el pulpo choca con la letra falsa y el projectile mata la letra correcta...)
	public void IncorrectoDestroyed() {
		//// Destroy all of the falling Apples
		GameObject[] tIncorrectoArray = GameObject.FindGameObjectsWithTag( "Incorrecto" );
		foreach ( GameObject tGO in tIncorrectoArray ) {
			Destroy( tGO );
		}
		GameObject[] tCorrectoArray = GameObject.FindGameObjectsWithTag( "Yes" );
		foreach ( GameObject tGO in tCorrectoArray ) {
			Destroy( tGO );
		}
		GameObject[] tProjectileArray = GameObject.FindGameObjectsWithTag( "Projectile" );
		foreach ( GameObject tGO in tProjectileArray ) {
			Destroy( tGO );
		}

		
		//// Destroy one of the Baskets
		// Get the index of the last Basket in basketList
		int heartIndex = heartList.Count-1;
		// Get a reference to that Basket GameObject
		GameObject tHeartGO = heartList[heartIndex];
		// Remove the Basket from the List and destroy the GameObject
		heartList.RemoveAt( heartIndex );
		//Heart1 = GameObject.Find ("Heart1");
		Destroy( tHeartGO );
		// Restart the game, which doesn't affect HighScore.Score
		if (heartList.Count == 0) {
			Application.LoadLevel ("_Escenario0");
		}
	}

/*	public void IceCreamDestroyed() {
		//// Destroy all of the falling Apples
		GameObject[] tIceCreamArray = GameObject.FindGameObjectsWithTag( "IceCream" );
		foreach ( GameObject tGO in tIceCreamArray ) {
			Destroy( tGO );
		}
		//// Destroy one of the Baskets
		// Get the index of the last Basket in basketList
		int basketIndex = basketList.Count-1;
		// Get a reference to that Basket GameObject
		GameObject tBasketGO = basketList[basketIndex];
		// Remove the Basket from the List and destroy the GameObject
		basketList.RemoveAt( basketIndex );
	//	Destroy( tBasketGO );
		// Restart the game, which doesn't affect HighScore.Score
		if (basketList.Count == 0) {
			Application.LoadLevel ("_Escenario0");
		}
	}

*/

	/*
	public void h1Destroyed(){
		GameObject h1GO = GameObject.Find("Heart1");
		Destroy (h1GO);

		}

	public void h2Destroyed(){
		GameObject h2GO = GameObject.Find("Heart2");
		Destroy (h2GO);

	}
	public void h3Destroyed(){
		GameObject h3GO = GameObject.Find("Heart3");
		Destroy (h3GO);
		NoHayVida = true;
	}

*/
	/*
	public void IncorrectoDestroyed() {
		//// Destroy all of the falling Apples
		GameObject[] tIncorrectoArray = GameObject.FindGameObjectsWithTag( "Incorrecto" );
		foreach ( GameObject tGO in tIncorrectoArray ) {
			Destroy( tGO );
		}
//			Application.LoadLevel ("_Escenario0");
	}
*/


}
