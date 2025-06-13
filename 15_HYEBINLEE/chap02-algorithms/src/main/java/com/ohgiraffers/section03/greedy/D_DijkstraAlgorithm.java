package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 다익스트라 알고리즘
 * 음의 가중치가 없는 그래프의 한 정점에서 모든 정점까지의 최단거리를 구하는 알고리즘
 * 간선에 가중치가 없으면 BFS로도 가능하지만, 가중치가 있다면 최단경로 보장이 어렵다.*/
public class D_DijkstraAlgorithm {

  static int n, m, start;     // 정점개수, 간선 개수, 시작 정점
  static int[] dis;         // 다른 노드까지의 거리를 저장할 배열


  static class Edge implements Comparable<Edge> {

    int n;
    int cost;

    Edge(int var, int cost) {
      this.n = var;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return this.cost - o.cost;  // 가중치 오름차순의 우선순위
    }
  }

  public static String solution(String input) throws IOException {

    BufferedReader br = new BufferedReader(new StringReader(input));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    // 각 노드의 가중치를 기록할 배열
    dis = new int[n + 1];
    // 아직 거리가 판단되지 않은 경우에는 Integer 최대값으로 채워둔다.
    Arrays.fill(dis, Integer.MAX_VALUE);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());     // 시작정점
      int b = Integer.parseInt(st.nextToken());     // 도착정점
      int c = Integer.parseInt(st.nextToken());     // 가중치
      graph.get(a).add(new Edge(b, c));
    }

    // 우선순위 큐에 Edge가 담겼을 때, 우선순위는 가중치가 낮은 순서로 정해진다.
     PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(start, 0));
    dis[start] = 0;

    while (!pq.isEmpty()) {
      Edge cur = pq.poll();

      if(cur.cost > dis[cur.n]) {
        continue;
      }

      // 기준 정점과 연결되 이웃 정점을 큐에 추가하는 반복문
      for(Edge edge : graph.get(cur.n)) {
        // 거리를 기록해두는 배열에 저장된 값이 현재 비용과 간선을 타고가는 비용을 더한 값보다 크다면
        if(dis[edge.n] > cur.cost + edge.cost) {
          // 새로운 루트로 업데이트 한다.
          dis[edge.n] = cur.cost + edge.cost;
          pq.offer(new Edge(edge.n, cur.cost + edge.cost));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i < dis.length; i++) {
      if(dis[i] != Integer.MAX_VALUE) {
        sb.append(dis[i]);
      } else {
        sb.append("impossible");
      }
      sb.append(" ");
    }
    System.out.println("확인: " + sb.toString());
    return sb.toString().trim();
  }
}
