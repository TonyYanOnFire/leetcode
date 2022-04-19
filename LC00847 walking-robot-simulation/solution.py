# lc874
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