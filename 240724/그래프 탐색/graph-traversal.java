import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]),m=Integer.parseInt(input[1]);
        nds = new HashMap<>();
        if(m == 0){
            System.out.print(0);
            return;
        }
        for(int i = 0; i < m; i++) {
        	String [] inp = br.readLine().split(" ");
        	
        	if(!nds.containsKey(inp[0]))nds.put(inp[0], new nd(Integer.parseInt(inp[0])));
        	if(!nds.containsKey(inp[1]))nds.put(inp[1], new nd(Integer.parseInt(inp[1])));
        	
        	nd nA = nds.get(inp[0]), nB = nds.get(inp[1]);
        	nA.nds.put(inp[1], nB);
        	nB.nds.put(inp[0], nA);
        }
        nSet.add(1 + "");
        DFS(nds.get(1 + ""));
        System.out.println(nSet.size()-1);
    }
	static Map <String,nd> nds;//노드 꺼내오는용
	static Set<String> nSet = new HashSet<>();//방문여부 확인
	static void DFS(nd N) {
		if(Objects.isNull(N))return;
		if(!N.nds.isEmpty()) {
			Object [] ndss = N.nds.keySet().toArray();//방문가능한 노드의 배열
			for(int i = 0; i < ndss.length;i ++) {
				if(!nSet.contains((String)ndss[i])) {//방문하지 않았을 경우
					nSet.add((String)ndss[i]);//방문처리
					DFS(nds.get(ndss[i]));//방문해서 다시 dfs
				}
			}
		}
		
		
		
	}
	
	
}
class nd{
	int num;
	Map <String,nd> nds = new HashMap<>();
	public nd(int num) {
		this.num = num;
	}
}