class Solution {
    public int orangesRotting(int[][] grid) {
        int delx[]={-1,1,0,0};
        int dely[]={0,0,1,-1};
        
        Queue<Integer> row=new LinkedList<>();
        Queue<Integer> col=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    row.add(i);
                    col.add(j);
                }
                else if(grid[i][j]==1)
                    cnt++;
            }
        }
        
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        while(!row.isEmpty())
        {
            int size=row.size();
            for(int i=0;i<size;i++)
            {
                int x=row.poll();
                int y=col.poll();
                for(int k=0;k<4;k++)
                {
                    int tempx=x+delx[k];
                    int tempy=y+dely[k];
                    if(tempx>=0 && tempx<n && tempy>=0 && tempy<m && grid[tempx][tempy]==1)
                    {
                        grid[tempx][tempy]=2;
                        row.add(tempx);
                        col.add(tempy);
                        cnt--;
                    }
                }
            }
            ans++;
        }
        
        return cnt==0?ans-1:-1;
    }
}