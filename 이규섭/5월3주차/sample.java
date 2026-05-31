import java.util.*;

class Solution {
    
    static boolean[][] visit;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
        int[] oil_by_col = new int[m];
        visit = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j] == 1 && !visit[i][j]){
                    bfs(land,j,i,n,m, oil_by_col);
                }
            }
        }
        int answer = 0;
        for (int oil : oil_by_col) {
            answer = Math.max(answer, oil);
        }
        
        return answer;
    }
    
    public static int bfs(int[][] land,int x, int y, int n, int m, int[] oil_by_col){
        
        Queue<int[]> que = new LinkedList<>();
        Set<Integer> column = new HashSet<>();
        
        que.add(new int[]{y,x});
        visit[y][x] = true;
        int cnt =0;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            cnt++;
            column.add(cur[1]);
            
            for(int i=0;i<4;i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                
                if(land[ny][nx] == 1 && !visit[ny][nx]){
                    que.add(new int[]{ny,nx});
                    visit[ny][nx] = true;
                }
            }
        }
        
        for(int col:column){
            oil_by_col[col] += cnt;
        }
        
        return cnt;
    }
    
}


//https://school.programmers.co.kr/learn/courses/30/lessons/250136
