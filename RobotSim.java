import java.util.HashSet;



/**
 * RobotSim
 */
public class RobotSim {
    // 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：

    // -2：向左转 90 度
    // -1：向右转 90 度
    // 1 <= x <= 9：向前移动 x 个单位长度
    // 在网格上有一些格子被视为障碍物。
    
    // 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
    
    // 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
    
    // 返回从原点到机器人的最大欧式距离的平方。
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/walking-robot-simulation
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;

        int angle = 0;//到y的角度
        HashSet<String>obstaclesSet = new HashSet<>();
        int res = 0;
        //编码成字符串，完美
        for (int i = 0; i < obstacles.length; i++) {
            // Position  p = new Position(obstacles[i][0], obstacles[i][1]);
            String p = "("+obstacles[i][0]+","+obstacles[i][1]+")";
            obstaclesSet.add(p);
        }

        for (int command : commands) {
            if(command==-1) angle = (angle+90)%360;

            else if(command==-2) angle = (angle+270)%360;

            else{

                if (angle==0) {
                    for(int i=0;i<command;i++){
                        // Position  p = new Position(x,y+1);
                        String p = "("+x+","+(y+1)+")";
                        if(obstaclesSet.contains(p)){
                            break;
                        }
                        y++;
                    }

                } else if(angle==90) {
                    for(int i=0;i<command;i++){
                        // Position  p = new Position(x+1,y);
                        String p = "("+(x+1)+","+y+")";
                        if(obstaclesSet.contains(p)){
                            break;
                        }
                        x++;
                    }
                }else if(angle==180) {
                    for(int i=0;i<command;i++){
                        // Position  p = new Position(x,y-1);
                        String p = "("+x+","+(y-1)+")";
                        if(obstaclesSet.contains(p)){
                            break;
                        }
                        y--;
                    }
                }else if(angle==270) {
                    for(int i=0;i<command;i++){
                        // Position  p = new Position(x-1,y);
                        String p = "("+(x-1)+","+y+")";
                        if(obstaclesSet.contains(p)){
                            break;
                        }
                        x--;
                    }
                }
            }
            
            res = Math.max(res, x*x+y*y);
        }

        return res;
    }

    // class Position{
    //     public int x;
    //     public int y;

    //     public Position(int x,int y){
    //         this.x =x;
    //         this.y =y;

    //     }
    // }
    public static void main(String[] args) {
        RobotSim robotSim = new RobotSim();
        int []commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        System.out.println(robotSim.robotSim(commands, obstacles));
    }
}