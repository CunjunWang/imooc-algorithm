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
CMAKE_SOURCE_DIR = /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/flags.make

CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.o: CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/flags.make
CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.o -c /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/main.cpp

CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/main.cpp > CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.i

CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/main.cpp -o CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.s

# Object files for target LeetCode104_MaximumDepthOfBinaryTree
LeetCode104_MaximumDepthOfBinaryTree_OBJECTS = \
"CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.o"

# External object files for target LeetCode104_MaximumDepthOfBinaryTree
LeetCode104_MaximumDepthOfBinaryTree_EXTERNAL_OBJECTS =

LeetCode104_MaximumDepthOfBinaryTree: CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/main.cpp.o
LeetCode104_MaximumDepthOfBinaryTree: CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/build.make
LeetCode104_MaximumDepthOfBinaryTree: CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable LeetCode104_MaximumDepthOfBinaryTree"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/build: LeetCode104_MaximumDepthOfBinaryTree

.PHONY : CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/build

CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/cmake_clean.cmake
.PHONY : CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/clean

CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/depend:
	cd /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/cmake-build-debug /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/cmake-build-debug /Users/CunjunWang/Desktop/Algorithm/imooc-algorithm/interview-algorithm/binary-search-tree/LeetCode104_MaximumDepthOfBinaryTree/cmake-build-debug/CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/LeetCode104_MaximumDepthOfBinaryTree.dir/depend
