# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/LeetCode70_ClimbingStairs.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/LeetCode70_ClimbingStairs.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/LeetCode70_ClimbingStairs.dir/flags.make

CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.o: CMakeFiles/LeetCode70_ClimbingStairs.dir/flags.make
CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.o -c /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/main.cpp

CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/main.cpp > CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.i

CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/main.cpp -o CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.s

# Object files for target LeetCode70_ClimbingStairs
LeetCode70_ClimbingStairs_OBJECTS = \
"CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.o"

# External object files for target LeetCode70_ClimbingStairs
LeetCode70_ClimbingStairs_EXTERNAL_OBJECTS =

LeetCode70_ClimbingStairs: CMakeFiles/LeetCode70_ClimbingStairs.dir/main.cpp.o
LeetCode70_ClimbingStairs: CMakeFiles/LeetCode70_ClimbingStairs.dir/build.make
LeetCode70_ClimbingStairs: CMakeFiles/LeetCode70_ClimbingStairs.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable LeetCode70_ClimbingStairs"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/LeetCode70_ClimbingStairs.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/LeetCode70_ClimbingStairs.dir/build: LeetCode70_ClimbingStairs

.PHONY : CMakeFiles/LeetCode70_ClimbingStairs.dir/build

CMakeFiles/LeetCode70_ClimbingStairs.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/LeetCode70_ClimbingStairs.dir/cmake_clean.cmake
.PHONY : CMakeFiles/LeetCode70_ClimbingStairs.dir/clean

CMakeFiles/LeetCode70_ClimbingStairs.dir/depend:
	cd /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/cmake-build-debug /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/cmake-build-debug /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/dynamic-programming/LeetCode70_ClimbingStairs/cmake-build-debug/CMakeFiles/LeetCode70_ClimbingStairs.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/LeetCode70_ClimbingStairs.dir/depend

