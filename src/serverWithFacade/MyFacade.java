/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverWithFacade;

/**
 *
 * @author AreYouG
 */
public class MyFacade {
    private static MyFacade myFacadeObj = null;
    private MyFacade(){}
    public static MyFacade getMyFacadeObject(){
        if(myFacadeObj == null){
            myFacadeObj = new MyFacade();
            server = new ScheduleServer();
        }
        return myFacadeObj;
    }
    private static ScheduleServer server;
    
    public void start(){
        server.startBooting();
	server.readSystemConfigFile();
	server.init();
	server.initializeContext();
	server.initializeListeners();
	server.createSystemObjects();
	
    }
    
    public void stop(){
        server.releaseProcesses();
	server.destory();
	server.destroySystemObjects();
	server.destoryListeners();
	server.destoryContext();
	server.shutdown();
    }
}
