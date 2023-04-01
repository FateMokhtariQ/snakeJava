import pygame
import time
import random
 
pygame.init()
 
# Define the colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)
 
# Set the width and height of the screen [width, height]
WIDTH = 500
HEIGHT = 500
 
# Set the block size and speed of the snake
BLOCK_SIZE = 10
SPEED = 20
 
# Initialize the window
window = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Snake Game")
 
# Initialize the clock
clock = pygame.time.Clock()
 
# Function to display a message on the screen
def message_to_screen(msg, color):
    font = pygame.font.SysFont(None, 25)
    screen_text = font.render(msg, True, color)
    window.blit(screen_text, [WIDTH/6, HEIGHT/2])
 
# Main game loop
def gameLoop():
    game_over = False
    game_close = False
 
    # Initial position of the snake
    x1 = WIDTH / 2
    y1 = HEIGHT / 2
 
    # Change in position of the snake
    x1_change = 0       
    y1_change = 0
 
    # List to keep track of the body of the snake
    snake_List = []
    Length_of_snake = 1
 
    # Random position of the food
    foodx = round(random.randrange(0, WIDTH - BLOCK_SIZE) / 10.0) * 10.0
    foody = round(random.randrange(0, HEIGHT - BLOCK_SIZE) / 10.0) * 10.0
 
    # Main game loop
    while not game_over:
 
        while game_close == True:
            window.fill(WHITE)
            message_to_screen("You Lost! Press Q-Quit or C-Play Again", RED)
            pygame.display.update()
 
            for event in pygame.event.get():
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_q:
                        game_over = True
                        game_close = False
                    if event.key == pygame.K_c:
                        gameLoop()
 
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                game_over = True
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LEFT:
                    x1_change = -BLOCK_SIZE
                    y1_change = 0
                elif event.key == pygame.K_RIGHT:
                    x1_change = BLOCK_SIZE
                    y1_change = 0
                elif event.key == pygame.K_UP:
                    y1_change = -BLOCK_SIZE
                    x1_change = 0
                elif event.key == pygame.K_DOWN:
                    y1_change = BLOCK_SIZE
                    x1_change = 0
 
        # Check if snake hits the boundaries
        if x1 >= WIDTH or x1 < 0 or y1 >= HEIGHT or y1 < 0:
            game_close = True
 
        # Update the position of the snake
        x1 += x1_change
        y1 += y1_change
 
        window.fill(WHITE)
        pygame.draw.rect(window, GREEN, [foodx, foody, BLOCK_SIZE, BLOCK_SIZE])
 
        # Append the current position of the head of the snake to the list
        snake_Head = []
        snake_Head.append(x1)
        snake_Head.append(y1)
        snake_List
