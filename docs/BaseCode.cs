using UnityEngine;
using System.Collections;
using System.Collections.Generic;  
using Com.ZQX;

namespace Com.ZQX{
	public interface IUserInterface{
		void fireDisk();  
	}
	public interface IQueryGameStatus{
		bool isCounting();  
		bool isShooting();  
		int getRound();  
		int getPoint();  
		int getFireTime();  
	}
	public interface IJudgeEvent{
		void nextRound();  
		void setPoint(int point); 
	}
	public class SceneController : System.Object, IUserInterface, IQueryGameStatus, IJudgeEvent {
		public static SceneController _instance;
		private BaseCode _basecode;
		private Judge _judge;
		private GameModel _gamemodel;
		public static SceneController getInstance() {
			if (_instance == null) {
				_instance = new SceneController();
			}
			return _instance;
		}
		public void setBaseCode(BaseCode b) {_basecode = b;}
		internal BaseCode getBaseCode() {return _basecode;}
		public void setJudge(Judge b) {_judge = b;}
		internal Judge getJudge() {return _judge;}
		public void setGameModel(GameModel b) {_gamemodel = b;}
		internal GameModel getGameModel() {return _gamemodel;}
		public void fireDisk() {
			_gamemodel.prepareToEmitDisk ();
		}
		public bool isCounting() {
			return _gamemodel.isCounting ();
		}
		public bool isShooting() {
			return _gamemodel.isShooting ();
		}
		public int getRound() {
			return _basecode.round;
		}
		public int getPoint() {
			return _basecode.point;
		}
		public int getFireTime() {
			return (int)(_gamemodel.timeToFire + 1);
		}
		public void nextRound() {
			this.setPoint (0);
			_basecode.round++;
			_basecode.loadData ();
		}
		public void setPoint(int point) {
			_basecode.point = point;
		}
	}
	public class DiskFactory : System.Object {  
		private static DiskFactory _instance;  
		private static List<GameObject> diskList;
		public GameObject diskTemp;
		public static DiskFactory getInstance() {  
			if (_instance == null) {  
				_instance = new DiskFactory();  
				diskList = new List<GameObject>();  
			}  
			return _instance;  
		}  
		public int getDisk() {   
			for (int i = 0; i < diskList.Count; ++i) {  
				if (!diskList[i].activeInHierarchy) {  
					return i;  
				}  
			}  
			diskList.Add(GameObject.Instantiate(diskTemp) as GameObject);  
			return diskList.Count-1;  
		}  
		public GameObject getDiskObject(int id) {  
			if (id >= 0 && id < diskList.Count) {  
				return diskList[id];  
			}  
			return null;  
		}  
		public void free(int id) {  
			if (id >= 0 && id < diskList.Count) {  
				diskList[id].GetComponent<Rigidbody>().velocity = Vector3.zero;  
				diskList[id].transform.localScale = diskTemp.transform.localScale;  
				diskList[id].SetActive(false);  
			}  
		}  
	} 
}

public class BaseCode : MonoBehaviour {
	public GameObject disk;
	private Color c;
	private Vector3 positon, dir;
	private float speed;
	private int scale;
	public int round = 0;
	public int point = 0;
	// Use this for initialization
	void Awake () {
		DiskFactory.getInstance ().diskTemp = disk;
		SceneController.getInstance ().setBaseCode (this);
	}
	public void loadData() {
		if (round == 1) {
			c = Color.red;
			positon = new Vector3(-2, 0, -5);
			dir = new Vector3(24, 30, 50);
			speed = 0.5f;
			scale = 1;
			SceneController.getInstance().getGameModel().setData(scale, c, positon, dir, speed, 1);
		}
		else if (round == 2) {
			c = Color.green;
			positon = new Vector3(2, 0, -5);
			dir = new Vector3(-24, 20, 50);
			speed = 0.7f;
			scale = 1;
			SceneController.getInstance().getGameModel().setData(scale, c, positon, dir, speed, 2);
		}
	}
}
