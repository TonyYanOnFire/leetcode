# https://leetcode-cn.com/problems/walking-robot-simulation/

class Solution:
  def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
      max_dist = 0
      x = y = 0
      directions = ['y', '-x', '-y', 'x']
      direction_index = 0

      blocked_cells = set((x, y) for x, y in obstacles)

      for command in commands:
          if command == -2:
              direction_index = (direction_index + 1) % 4
          elif command == -1:
              direction_index = (direction_index - 1) % 4
          else:
              direction = directions[direction_index]
              while command > 0:
                  next_x, next_y = x, y
                  if direction == 'y':
                      next_y += 1
                  elif direction == '-x':
                      next_x -= 1
                  elif direction == '-y':
                      next_y -= 1
                  elif direction == 'x':
                      next_x += 1
                  if (next_x, next_y) in blocked_cells:
                      max_dist = max(max_dist, x ** 2 + y ** 2)
                      break
                  x, y = next_x, next_y
                  command -= 1
              max_dist = max(max_dist, x ** 2 + y ** 2)

      return max_dist

"""
并不算难的一道题. 之前是简单难度, 可能是通过率比较低, 改成了困难.
几个关键点: 使用哈希表而不是矩阵储存障碍物. 按照题设给出最大范围和最大障碍物数, 密度为1 / (9e4), 即空间利用率很低且开销大
关键在于键值的计算方式. 此处利用了python的set hashable的特性. 如果语言没有这个特性可以考虑用字符串"x,y", 或者计算坐标序号 x * M + y, M为x轴范围

针对类似的地图走格子问题, 还有一些技巧.
处理方向时, 语言如果不支持负索引, 可以加上3, 即 - 1 + 4
direction_index = (direction_index - 1 + 4) % 4

方向的计算通过构建dx_list, dy_list计算
directions = ['y', '-x', '-y', 'x']
dx_list = [0, -1, 0, 1]
dy_list = [1, 0, -1, 0]
x, y = x + dx_list[direction_index], y + dy_list[direction_index]
"""