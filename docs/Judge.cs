using UnityEngine;
using System.Collections;
using Com.ZQX;
public class Judge : MonoBehaviour {
	public int oneDiskScore = 10;  
	public int oneDiskFail = 10;
	//击中多少个飞碟开始下一关
	public int diskNumForWin = 5;  
	
	private SceneController scene;  
	
	void Awake() {  
		scene = SceneController.getInstance();  
		scene.setJudge(this);  
	}
	//得分
	public void scoreADisk() {  
		scene.setPoint(scene.getPoint() + oneDiskScore);  
		if (scene.getPoint() == diskNumForWin*oneDiskScore) {  
			scene.nextRound();  
		}  
	}
	//失分
	public void failADisk() {  
		scene.setPoint(scene.getPoint() - oneDiskFail);  
	} 
}
