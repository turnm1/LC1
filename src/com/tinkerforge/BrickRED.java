/* ***********************************************************
 * This file was automatically generated on 2016-02-10.      *
 *                                                           *
 * Java Bindings Version 2.1.8                               *
 *                                                           *
 * If you have a bugfix for this file and want to commit it, *
 * please fix the bug in the generator. You can find a link  *
 * to the generators git repository on tinkerforge.com       *
 *************************************************************/

package com.tinkerforge;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Executes user programs and controls other Bricks/Bricklets standalone
 */
public class BrickRED extends Device {
	public final static int DEVICE_IDENTIFIER = 17;
	public final static String DEVICE_DISPLAY_NAME = "RED Brick";

	public final static byte FUNCTION_CREATE_SESSION = (byte)1;
	public final static byte FUNCTION_EXPIRE_SESSION = (byte)2;
	public final static byte FUNCTION_EXPIRE_SESSION_UNCHECKED = (byte)3;
	public final static byte FUNCTION_KEEP_SESSION_ALIVE = (byte)4;
	public final static byte FUNCTION_RELEASE_OBJECT = (byte)5;
	public final static byte FUNCTION_RELEASE_OBJECT_UNCHECKED = (byte)6;
	public final static byte FUNCTION_ALLOCATE_STRING = (byte)7;
	public final static byte FUNCTION_TRUNCATE_STRING = (byte)8;
	public final static byte FUNCTION_GET_STRING_LENGTH = (byte)9;
	public final static byte FUNCTION_SET_STRING_CHUNK = (byte)10;
	public final static byte FUNCTION_GET_STRING_CHUNK = (byte)11;
	public final static byte FUNCTION_ALLOCATE_LIST = (byte)12;
	public final static byte FUNCTION_GET_LIST_LENGTH = (byte)13;
	public final static byte FUNCTION_GET_LIST_ITEM = (byte)14;
	public final static byte FUNCTION_APPEND_TO_LIST = (byte)15;
	public final static byte FUNCTION_REMOVE_FROM_LIST = (byte)16;
	public final static byte FUNCTION_OPEN_FILE = (byte)17;
	public final static byte FUNCTION_CREATE_PIPE = (byte)18;
	public final static byte FUNCTION_GET_FILE_INFO = (byte)19;
	public final static byte FUNCTION_READ_FILE = (byte)20;
	public final static byte FUNCTION_READ_FILE_ASYNC = (byte)21;
	public final static byte FUNCTION_ABORT_ASYNC_FILE_READ = (byte)22;
	public final static byte FUNCTION_WRITE_FILE = (byte)23;
	public final static byte FUNCTION_WRITE_FILE_UNCHECKED = (byte)24;
	public final static byte FUNCTION_WRITE_FILE_ASYNC = (byte)25;
	public final static byte FUNCTION_SET_FILE_POSITION = (byte)26;
	public final static byte FUNCTION_GET_FILE_POSITION = (byte)27;
	public final static byte FUNCTION_SET_FILE_EVENTS = (byte)28;
	public final static byte FUNCTION_GET_FILE_EVENTS = (byte)29;
	public final static byte CALLBACK_ASYNC_FILE_READ = (byte)30;
	public final static byte CALLBACK_ASYNC_FILE_WRITE = (byte)31;
	public final static byte CALLBACK_FILE_EVENTS_OCCURRED = (byte)32;
	public final static byte FUNCTION_OPEN_DIRECTORY = (byte)33;
	public final static byte FUNCTION_GET_DIRECTORY_NAME = (byte)34;
	public final static byte FUNCTION_GET_NEXT_DIRECTORY_ENTRY = (byte)35;
	public final static byte FUNCTION_REWIND_DIRECTORY = (byte)36;
	public final static byte FUNCTION_CREATE_DIRECTORY = (byte)37;
	public final static byte FUNCTION_GET_PROCESSES = (byte)38;
	public final static byte FUNCTION_SPAWN_PROCESS = (byte)39;
	public final static byte FUNCTION_KILL_PROCESS = (byte)40;
	public final static byte FUNCTION_GET_PROCESS_COMMAND = (byte)41;
	public final static byte FUNCTION_GET_PROCESS_IDENTITY = (byte)42;
	public final static byte FUNCTION_GET_PROCESS_STDIO = (byte)43;
	public final static byte FUNCTION_GET_PROCESS_STATE = (byte)44;
	public final static byte CALLBACK_PROCESS_STATE_CHANGED = (byte)45;
	public final static byte FUNCTION_GET_PROGRAMS = (byte)46;
	public final static byte FUNCTION_DEFINE_PROGRAM = (byte)47;
	public final static byte FUNCTION_PURGE_PROGRAM = (byte)48;
	public final static byte FUNCTION_GET_PROGRAM_IDENTIFIER = (byte)49;
	public final static byte FUNCTION_GET_PROGRAM_ROOT_DIRECTORY = (byte)50;
	public final static byte FUNCTION_SET_PROGRAM_COMMAND = (byte)51;
	public final static byte FUNCTION_GET_PROGRAM_COMMAND = (byte)52;
	public final static byte FUNCTION_SET_PROGRAM_STDIO_REDIRECTION = (byte)53;
	public final static byte FUNCTION_GET_PROGRAM_STDIO_REDIRECTION = (byte)54;
	public final static byte FUNCTION_SET_PROGRAM_SCHEDULE = (byte)55;
	public final static byte FUNCTION_GET_PROGRAM_SCHEDULE = (byte)56;
	public final static byte FUNCTION_GET_PROGRAM_SCHEDULER_STATE = (byte)57;
	public final static byte FUNCTION_CONTINUE_PROGRAM_SCHEDULE = (byte)58;
	public final static byte FUNCTION_START_PROGRAM = (byte)59;
	public final static byte FUNCTION_GET_LAST_SPAWNED_PROGRAM_PROCESS = (byte)60;
	public final static byte FUNCTION_GET_CUSTOM_PROGRAM_OPTION_NAMES = (byte)61;
	public final static byte FUNCTION_SET_CUSTOM_PROGRAM_OPTION_VALUE = (byte)62;
	public final static byte FUNCTION_GET_CUSTOM_PROGRAM_OPTION_VALUE = (byte)63;
	public final static byte FUNCTION_REMOVE_CUSTOM_PROGRAM_OPTION = (byte)64;
	public final static byte CALLBACK_PROGRAM_SCHEDULER_STATE_CHANGED = (byte)65;
	public final static byte CALLBACK_PROGRAM_PROCESS_SPAWNED = (byte)66;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static short ERROR_CODE_SUCCESS = (short)0;
	public final static short ERROR_CODE_UNKNOWN_ERROR = (short)1;
	public final static short ERROR_CODE_INVALID_OPERATION = (short)2;
	public final static short ERROR_CODE_OPERATION_ABORTED = (short)3;
	public final static short ERROR_CODE_INTERNAL_ERROR = (short)4;
	public final static short ERROR_CODE_UNKNOWN_SESSION_ID = (short)5;
	public final static short ERROR_CODE_NO_FREE_SESSION_ID = (short)6;
	public final static short ERROR_CODE_UNKNOWN_OBJECT_ID = (short)7;
	public final static short ERROR_CODE_NO_FREE_OBJECT_ID = (short)8;
	public final static short ERROR_CODE_OBJECT_IS_LOCKED = (short)9;
	public final static short ERROR_CODE_NO_MORE_DATA = (short)10;
	public final static short ERROR_CODE_WRONG_LIST_ITEM_TYPE = (short)11;
	public final static short ERROR_CODE_PROGRAM_IS_PURGED = (short)12;
	public final static short ERROR_CODE_INVALID_PARAMETER = (short)128;
	public final static short ERROR_CODE_NO_FREE_MEMORY = (short)129;
	public final static short ERROR_CODE_NO_FREE_SPACE = (short)130;
	public final static short ERROR_CODE_ACCESS_DENIED = (short)121;
	public final static short ERROR_CODE_ALREADY_EXISTS = (short)132;
	public final static short ERROR_CODE_DOES_NOT_EXIST = (short)133;
	public final static short ERROR_CODE_INTERRUPTED = (short)134;
	public final static short ERROR_CODE_IS_DIRECTORY = (short)135;
	public final static short ERROR_CODE_NOT_A_DIRECTORY = (short)136;
	public final static short ERROR_CODE_WOULD_BLOCK = (short)137;
	public final static short ERROR_CODE_OVERFLOW = (short)138;
	public final static short ERROR_CODE_BAD_FILE_DESCRIPTOR = (short)139;
	public final static short ERROR_CODE_OUT_OF_RANGE = (short)140;
	public final static short ERROR_CODE_NAME_TOO_LONG = (short)141;
	public final static short ERROR_CODE_INVALID_SEEK = (short)142;
	public final static short ERROR_CODE_NOT_SUPPORTED = (short)143;
	public final static short ERROR_CODE_TOO_MANY_OPEN_FILES = (short)144;
	public final static short OBJECT_TYPE_STRING = (short)0;
	public final static short OBJECT_TYPE_LIST = (short)1;
	public final static short OBJECT_TYPE_FILE = (short)2;
	public final static short OBJECT_TYPE_DIRECTORY = (short)3;
	public final static short OBJECT_TYPE_PROCESS = (short)4;
	public final static short OBJECT_TYPE_PROGRAM = (short)5;
	public final static long FILE_FLAG_READ_ONLY = 1L;
	public final static long FILE_FLAG_WRITE_ONLY = 2L;
	public final static long FILE_FLAG_READ_WRITE = 4L;
	public final static long FILE_FLAG_APPEND = 8L;
	public final static long FILE_FLAG_CREATE = 16L;
	public final static long FILE_FLAG_EXCLUSIVE = 32L;
	public final static long FILE_FLAG_NON_BLOCKING = 64L;
	public final static long FILE_FLAG_TRUNCATE = 128L;
	public final static long FILE_FLAG_TEMPORARY = 256L;
	public final static long FILE_FLAG_REPLACE = 512L;
	public final static int FILE_PERMISSION_USER_ALL = 448;
	public final static int FILE_PERMISSION_USER_READ = 256;
	public final static int FILE_PERMISSION_USER_WRITE = 128;
	public final static int FILE_PERMISSION_USER_EXECUTE = 64;
	public final static int FILE_PERMISSION_GROUP_ALL = 56;
	public final static int FILE_PERMISSION_GROUP_READ = 32;
	public final static int FILE_PERMISSION_GROUP_WRITE = 16;
	public final static int FILE_PERMISSION_GROUP_EXECUTE = 8;
	public final static int FILE_PERMISSION_OTHERS_ALL = 7;
	public final static int FILE_PERMISSION_OTHERS_READ = 4;
	public final static int FILE_PERMISSION_OTHERS_WRITE = 2;
	public final static int FILE_PERMISSION_OTHERS_EXECUTE = 1;
	public final static long PIPE_FLAG_NON_BLOCKING_READ = 1L;
	public final static long PIPE_FLAG_NON_BLOCKING_WRITE = 2L;
	public final static short FILE_TYPE_UNKNOWN = (short)0;
	public final static short FILE_TYPE_REGULAR = (short)1;
	public final static short FILE_TYPE_DIRECTORY = (short)2;
	public final static short FILE_TYPE_CHARACTER = (short)3;
	public final static short FILE_TYPE_BLOCK = (short)4;
	public final static short FILE_TYPE_FIFO = (short)5;
	public final static short FILE_TYPE_SYMLINK = (short)6;
	public final static short FILE_TYPE_SOCKET = (short)7;
	public final static short FILE_TYPE_PIPE = (short)8;
	public final static short FILE_ORIGIN_BEGINNING = (short)0;
	public final static short FILE_ORIGIN_CURRENT = (short)1;
	public final static short FILE_ORIGIN_END = (short)2;
	public final static int FILE_EVENT_READABLE = 1;
	public final static int FILE_EVENT_WRITABLE = 2;
	public final static short DIRECTORY_ENTRY_TYPE_UNKNOWN = (short)0;
	public final static short DIRECTORY_ENTRY_TYPE_REGULAR = (short)1;
	public final static short DIRECTORY_ENTRY_TYPE_DIRECTORY = (short)2;
	public final static short DIRECTORY_ENTRY_TYPE_CHARACTER = (short)3;
	public final static short DIRECTORY_ENTRY_TYPE_BLOCK = (short)4;
	public final static short DIRECTORY_ENTRY_TYPE_FIFO = (short)5;
	public final static short DIRECTORY_ENTRY_TYPE_SYMLINK = (short)6;
	public final static short DIRECTORY_ENTRY_TYPE_SOCKET = (short)7;
	public final static long DIRECTORY_FLAG_RECURSIVE = 1L;
	public final static long DIRECTORY_FLAG_EXCLUSIVE = 2L;
	public final static short PROCESS_SIGNAL_INTERRUPT = (short)2;
	public final static short PROCESS_SIGNAL_QUIT = (short)3;
	public final static short PROCESS_SIGNAL_ABORT = (short)6;
	public final static short PROCESS_SIGNAL_KILL = (short)9;
	public final static short PROCESS_SIGNAL_USER1 = (short)10;
	public final static short PROCESS_SIGNAL_USER2 = (short)12;
	public final static short PROCESS_SIGNAL_TERMINATE = (short)15;
	public final static short PROCESS_SIGNAL_CONTINUE = (short)18;
	public final static short PROCESS_SIGNAL_STOP = (short)19;
	public final static short PROCESS_STATE_UNKNOWN = (short)0;
	public final static short PROCESS_STATE_RUNNING = (short)1;
	public final static short PROCESS_STATE_ERROR = (short)2;
	public final static short PROCESS_STATE_EXITED = (short)3;
	public final static short PROCESS_STATE_KILLED = (short)4;
	public final static short PROCESS_STATE_STOPPED = (short)5;
	public final static short PROGRAM_STDIO_REDIRECTION_DEV_NULL = (short)0;
	public final static short PROGRAM_STDIO_REDIRECTION_PIPE = (short)1;
	public final static short PROGRAM_STDIO_REDIRECTION_FILE = (short)2;
	public final static short PROGRAM_STDIO_REDIRECTION_INDIVIDUAL_LOG = (short)3;
	public final static short PROGRAM_STDIO_REDIRECTION_CONTINUOUS_LOG = (short)4;
	public final static short PROGRAM_STDIO_REDIRECTION_STDOUT = (short)5;
	public final static short PROGRAM_START_MODE_NEVER = (short)0;
	public final static short PROGRAM_START_MODE_ALWAYS = (short)1;
	public final static short PROGRAM_START_MODE_INTERVAL = (short)2;
	public final static short PROGRAM_START_MODE_CRON = (short)3;
	public final static short PROGRAM_SCHEDULER_STATE_STOPPED = (short)0;
	public final static short PROGRAM_SCHEDULER_STATE_RUNNING = (short)1;

	private List<AsyncFileReadListener> listenerAsyncFileRead = new CopyOnWriteArrayList<AsyncFileReadListener>();
	private List<AsyncFileWriteListener> listenerAsyncFileWrite = new CopyOnWriteArrayList<AsyncFileWriteListener>();
	private List<FileEventsOccurredListener> listenerFileEventsOccurred = new CopyOnWriteArrayList<FileEventsOccurredListener>();
	private List<ProcessStateChangedListener> listenerProcessStateChanged = new CopyOnWriteArrayList<ProcessStateChangedListener>();
	private List<ProgramSchedulerStateChangedListener> listenerProgramSchedulerStateChanged = new CopyOnWriteArrayList<ProgramSchedulerStateChangedListener>();
	private List<ProgramProcessSpawnedListener> listenerProgramProcessSpawned = new CopyOnWriteArrayList<ProgramProcessSpawnedListener>();

	public class CreateSession {
		public long lifetime;
		public short errorCode;
		public int sessionId;

		public String toString() {
			return "[" + "lifetime = " + lifetime + ", " + "errorCode = " + errorCode + ", " + "sessionId = " + sessionId + "]";
		}
	}

	public class AllocateString {
		public long lengthToReserve;
		public String buffer;
		public int sessionId;
		public short errorCode;
		public int stringId;

		public String toString() {
			return "[" + "lengthToReserve = " + lengthToReserve + ", " + "buffer = " + buffer + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "stringId = " + stringId + "]";
		}
	}

	public class StringLength {
		public int stringId;
		public short errorCode;
		public long length;

		public String toString() {
			return "[" + "stringId = " + stringId + ", " + "errorCode = " + errorCode + ", " + "length = " + length + "]";
		}
	}

	public class StringChunk {
		public int stringId;
		public long offset;
		public short errorCode;
		public String buffer;

		public String toString() {
			return "[" + "stringId = " + stringId + ", " + "offset = " + offset + ", " + "errorCode = " + errorCode + ", " + "buffer = " + buffer + "]";
		}
	}

	public class AllocateList {
		public int lengthToReserve;
		public int sessionId;
		public short errorCode;
		public int listId;

		public String toString() {
			return "[" + "lengthToReserve = " + lengthToReserve + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "listId = " + listId + "]";
		}
	}

	public class ListLength {
		public int listId;
		public short errorCode;
		public int length;

		public String toString() {
			return "[" + "listId = " + listId + ", " + "errorCode = " + errorCode + ", " + "length = " + length + "]";
		}
	}

	public class ListItem {
		public int listId;
		public int index;
		public int sessionId;
		public short errorCode;
		public int itemObjectId;
		public short type;

		public String toString() {
			return "[" + "listId = " + listId + ", " + "index = " + index + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "itemObjectId = " + itemObjectId + ", " + "type = " + type + "]";
		}
	}

	public class OpenFile {
		public int nameStringId;
		public long flags;
		public int permissions;
		public long uid;
		public long gid;
		public int sessionId;
		public short errorCode;
		public int fileId;

		public String toString() {
			return "[" + "nameStringId = " + nameStringId + ", " + "flags = " + flags + ", " + "permissions = " + permissions + ", " + "uid = " + uid + ", " + "gid = " + gid + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "fileId = " + fileId + "]";
		}
	}

	public class CreatePipe {
		public long flags;
		public long length;
		public int sessionId;
		public short errorCode;
		public int fileId;

		public String toString() {
			return "[" + "flags = " + flags + ", " + "length = " + length + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "fileId = " + fileId + "]";
		}
	}

	public class FileInfo {
		public int fileId;
		public int sessionId;
		public short errorCode;
		public short type;
		public int nameStringId;
		public long flags;
		public int permissions;
		public long uid;
		public long gid;
		public long length;
		public long accessTimestamp;
		public long modificationTimestamp;
		public long statusChangeTimestamp;

		public String toString() {
			return "[" + "fileId = " + fileId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "type = " + type + ", " + "nameStringId = " + nameStringId + ", " + "flags = " + flags + ", " + "permissions = " + permissions + ", " + "uid = " + uid + ", " + "gid = " + gid + ", " + "length = " + length + ", " + "accessTimestamp = " + accessTimestamp + ", " + "modificationTimestamp = " + modificationTimestamp + ", " + "statusChangeTimestamp = " + statusChangeTimestamp + "]";
		}
	}

	public class ReadFile {
		public int fileId;
		public short lengthToRead;
		public short errorCode;
		public short[] buffer = new short[62];
		public short lengthRead;

		public String toString() {
			return "[" + "fileId = " + fileId + ", " + "lengthToRead = " + lengthToRead + ", " + "errorCode = " + errorCode + ", " + "buffer = " + Arrays.toString(buffer) + ", " + "lengthRead = " + lengthRead + "]";
		}
	}

	public class WriteFile {
		public int fileId;
		public short[] buffer = new short[61];
		public short lengthToWrite;
		public short errorCode;
		public short lengthWritten;

		public String toString() {
			return "[" + "fileId = " + fileId + ", " + "buffer = " + Arrays.toString(buffer) + ", " + "lengthToWrite = " + lengthToWrite + ", " + "errorCode = " + errorCode + ", " + "lengthWritten = " + lengthWritten + "]";
		}
	}

	public class SetFilePosition {
		public int fileId;
		public long offset;
		public short origin;
		public short errorCode;
		public long position;

		public String toString() {
			return "[" + "fileId = " + fileId + ", " + "offset = " + offset + ", " + "origin = " + origin + ", " + "errorCode = " + errorCode + ", " + "position = " + position + "]";
		}
	}

	public class FilePosition {
		public int fileId;
		public short errorCode;
		public long position;

		public String toString() {
			return "[" + "fileId = " + fileId + ", " + "errorCode = " + errorCode + ", " + "position = " + position + "]";
		}
	}

	public class FileEvents {
		public int fileId;
		public short errorCode;
		public int events;

		public String toString() {
			return "[" + "fileId = " + fileId + ", " + "errorCode = " + errorCode + ", " + "events = " + events + "]";
		}
	}

	public class OpenDirectory {
		public int nameStringId;
		public int sessionId;
		public short errorCode;
		public int directoryId;

		public String toString() {
			return "[" + "nameStringId = " + nameStringId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "directoryId = " + directoryId + "]";
		}
	}

	public class DirectoryName {
		public int directoryId;
		public int sessionId;
		public short errorCode;
		public int nameStringId;

		public String toString() {
			return "[" + "directoryId = " + directoryId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "nameStringId = " + nameStringId + "]";
		}
	}

	public class NextDirectoryEntry {
		public int directoryId;
		public int sessionId;
		public short errorCode;
		public int nameStringId;
		public short type;

		public String toString() {
			return "[" + "directoryId = " + directoryId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "nameStringId = " + nameStringId + ", " + "type = " + type + "]";
		}
	}

	public class Processes {
		public int sessionId;
		public short errorCode;
		public int processesListId;

		public String toString() {
			return "[" + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "processesListId = " + processesListId + "]";
		}
	}

	public class SpawnProcess {
		public int executableStringId;
		public int argumentsListId;
		public int environmentListId;
		public int workingDirectoryStringId;
		public long uid;
		public long gid;
		public int stdinFileId;
		public int stdoutFileId;
		public int stderrFileId;
		public int sessionId;
		public short errorCode;
		public int processId;

		public String toString() {
			return "[" + "executableStringId = " + executableStringId + ", " + "argumentsListId = " + argumentsListId + ", " + "environmentListId = " + environmentListId + ", " + "workingDirectoryStringId = " + workingDirectoryStringId + ", " + "uid = " + uid + ", " + "gid = " + gid + ", " + "stdinFileId = " + stdinFileId + ", " + "stdoutFileId = " + stdoutFileId + ", " + "stderrFileId = " + stderrFileId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "processId = " + processId + "]";
		}
	}

	public class ProcessCommand {
		public int processId;
		public int sessionId;
		public short errorCode;
		public int executableStringId;
		public int argumentsListId;
		public int environmentListId;
		public int workingDirectoryStringId;

		public String toString() {
			return "[" + "processId = " + processId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "executableStringId = " + executableStringId + ", " + "argumentsListId = " + argumentsListId + ", " + "environmentListId = " + environmentListId + ", " + "workingDirectoryStringId = " + workingDirectoryStringId + "]";
		}
	}

	public class ProcessIdentity {
		public int processId;
		public short errorCode;
		public long pid;
		public long uid;
		public long gid;

		public String toString() {
			return "[" + "processId = " + processId + ", " + "errorCode = " + errorCode + ", " + "pid = " + pid + ", " + "uid = " + uid + ", " + "gid = " + gid + "]";
		}
	}

	public class ProcessStdio {
		public int processId;
		public int sessionId;
		public short errorCode;
		public int stdinFileId;
		public int stdoutFileId;
		public int stderrFileId;

		public String toString() {
			return "[" + "processId = " + processId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "stdinFileId = " + stdinFileId + ", " + "stdoutFileId = " + stdoutFileId + ", " + "stderrFileId = " + stderrFileId + "]";
		}
	}

	public class ProcessState {
		public int processId;
		public short errorCode;
		public short state;
		public long timestamp;
		public short exitCode;

		public String toString() {
			return "[" + "processId = " + processId + ", " + "errorCode = " + errorCode + ", " + "state = " + state + ", " + "timestamp = " + timestamp + ", " + "exitCode = " + exitCode + "]";
		}
	}

	public class Programs {
		public int sessionId;
		public short errorCode;
		public int programsListId;

		public String toString() {
			return "[" + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "programsListId = " + programsListId + "]";
		}
	}

	public class DefineProgram {
		public int identifierStringId;
		public int sessionId;
		public short errorCode;
		public int programId;

		public String toString() {
			return "[" + "identifierStringId = " + identifierStringId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "programId = " + programId + "]";
		}
	}

	public class ProgramIdentifier {
		public int programId;
		public int sessionId;
		public short errorCode;
		public int identifierStringId;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "identifierStringId = " + identifierStringId + "]";
		}
	}

	public class ProgramRootDirectory {
		public int programId;
		public int sessionId;
		public short errorCode;
		public int rootDirectoryStringId;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "rootDirectoryStringId = " + rootDirectoryStringId + "]";
		}
	}

	public class ProgramCommand {
		public int programId;
		public int sessionId;
		public short errorCode;
		public int executableStringId;
		public int argumentsListId;
		public int environmentListId;
		public int workingDirectoryStringId;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "executableStringId = " + executableStringId + ", " + "argumentsListId = " + argumentsListId + ", " + "environmentListId = " + environmentListId + ", " + "workingDirectoryStringId = " + workingDirectoryStringId + "]";
		}
	}

	public class ProgramStdioRedirection {
		public int programId;
		public int sessionId;
		public short errorCode;
		public short stdinRedirection;
		public int stdinFileNameStringId;
		public short stdoutRedirection;
		public int stdoutFileNameStringId;
		public short stderrRedirection;
		public int stderrFileNameStringId;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "stdinRedirection = " + stdinRedirection + ", " + "stdinFileNameStringId = " + stdinFileNameStringId + ", " + "stdoutRedirection = " + stdoutRedirection + ", " + "stdoutFileNameStringId = " + stdoutFileNameStringId + ", " + "stderrRedirection = " + stderrRedirection + ", " + "stderrFileNameStringId = " + stderrFileNameStringId + "]";
		}
	}

	public class ProgramSchedule {
		public int programId;
		public int sessionId;
		public short errorCode;
		public short startMode;
		public boolean continueAfterError;
		public long startInterval;
		public int startFieldsStringId;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "startMode = " + startMode + ", " + "continueAfterError = " + continueAfterError + ", " + "startInterval = " + startInterval + ", " + "startFieldsStringId = " + startFieldsStringId + "]";
		}
	}

	public class ProgramSchedulerState {
		public int programId;
		public int sessionId;
		public short errorCode;
		public short state;
		public long timestamp;
		public int messageStringId;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "state = " + state + ", " + "timestamp = " + timestamp + ", " + "messageStringId = " + messageStringId + "]";
		}
	}

	public class LastSpawnedProgramProcess {
		public int programId;
		public int sessionId;
		public short errorCode;
		public int processId;
		public long timestamp;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "processId = " + processId + ", " + "timestamp = " + timestamp + "]";
		}
	}

	public class CustomProgramOptionNames {
		public int programId;
		public int sessionId;
		public short errorCode;
		public int namesListId;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "namesListId = " + namesListId + "]";
		}
	}

	public class CustomProgramOptionValue {
		public int programId;
		public int nameStringId;
		public int sessionId;
		public short errorCode;
		public int valueStringId;

		public String toString() {
			return "[" + "programId = " + programId + ", " + "nameStringId = " + nameStringId + ", " + "sessionId = " + sessionId + ", " + "errorCode = " + errorCode + ", " + "valueStringId = " + valueStringId + "]";
		}
	}

	/**
	 * This listener reports the result of a call to the {@link BrickRED#readFileAsync(int, long)}
	 * function.
	 */
	public interface AsyncFileReadListener extends DeviceListener {
		public void asyncFileRead(int fileId, short errorCode, short[] buffer, short lengthRead);
	}

	/**
	 * This listener reports the result of a call to the {@link BrickRED#writeFileAsync(int, short[], short)}
	 * function.
	 */
	public interface AsyncFileWriteListener extends DeviceListener {
		public void asyncFileWrite(int fileId, short errorCode, short lengthWritten);
	}

	/**
	 * 
	 */
	public interface FileEventsOccurredListener extends DeviceListener {
		public void fileEventsOccurred(int fileId, int events);
	}

	/**
	 * 
	 */
	public interface ProcessStateChangedListener extends DeviceListener {
		public void processStateChanged(int processId, short state, long timestamp, short exitCode);
	}

	/**
	 * 
	 */
	public interface ProgramSchedulerStateChangedListener extends DeviceListener {
		public void programSchedulerStateChanged(int programId);
	}

	/**
	 * 
	 */
	public interface ProgramProcessSpawnedListener extends DeviceListener {
		public void programProcessSpawned(int programId);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickRED(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_CREATE_SESSION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_EXPIRE_SESSION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_EXPIRE_SESSION_UNCHECKED)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_KEEP_SESSION_ALIVE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_RELEASE_OBJECT)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_RELEASE_OBJECT_UNCHECKED)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_ALLOCATE_STRING)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_TRUNCATE_STRING)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_STRING_LENGTH)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_STRING_CHUNK)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_STRING_CHUNK)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_ALLOCATE_LIST)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_LIST_LENGTH)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_LIST_ITEM)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_APPEND_TO_LIST)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_REMOVE_FROM_LIST)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_OPEN_FILE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_CREATE_PIPE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_FILE_INFO)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_READ_FILE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_READ_FILE_ASYNC)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_ABORT_ASYNC_FILE_READ)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_WRITE_FILE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_WRITE_FILE_UNCHECKED)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_WRITE_FILE_ASYNC)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_FILE_POSITION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_FILE_POSITION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_FILE_EVENTS)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_FILE_EVENTS)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_OPEN_DIRECTORY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DIRECTORY_NAME)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_NEXT_DIRECTORY_ENTRY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_REWIND_DIRECTORY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_CREATE_DIRECTORY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROCESSES)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SPAWN_PROCESS)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_KILL_PROCESS)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROCESS_COMMAND)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROCESS_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROCESS_STDIO)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROCESS_STATE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROGRAMS)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_DEFINE_PROGRAM)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_PURGE_PROGRAM)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROGRAM_IDENTIFIER)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROGRAM_ROOT_DIRECTORY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_PROGRAM_COMMAND)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROGRAM_COMMAND)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_PROGRAM_STDIO_REDIRECTION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROGRAM_STDIO_REDIRECTION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_PROGRAM_SCHEDULE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROGRAM_SCHEDULE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PROGRAM_SCHEDULER_STATE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_CONTINUE_PROGRAM_SCHEDULE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_START_PROGRAM)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_LAST_SPAWNED_PROGRAM_PROCESS)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CUSTOM_PROGRAM_OPTION_NAMES)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CUSTOM_PROGRAM_OPTION_VALUE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CUSTOM_PROGRAM_OPTION_VALUE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_REMOVE_CUSTOM_PROGRAM_OPTION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ASYNC_FILE_READ)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ASYNC_FILE_WRITE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_FILE_EVENTS_OCCURRED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_PROCESS_STATE_CHANGED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_PROGRAM_SCHEDULER_STATE_CHANGED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_PROGRAM_PROCESS_SPAWNED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_ASYNC_FILE_READ] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int fileId = IPConnection.unsignedShort(bb.getShort());
				short errorCode = IPConnection.unsignedByte(bb.get());
				short[] buffer = new short[60];
				for(int i = 0; i < 60; i++) {
					buffer[i] = IPConnection.unsignedByte(bb.get());
				}

				short lengthRead = IPConnection.unsignedByte(bb.get());

				for(AsyncFileReadListener listener: listenerAsyncFileRead) {
					listener.asyncFileRead(fileId, errorCode, buffer, lengthRead);
				}
			}
		};

		callbacks[CALLBACK_ASYNC_FILE_WRITE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int fileId = IPConnection.unsignedShort(bb.getShort());
				short errorCode = IPConnection.unsignedByte(bb.get());
				short lengthWritten = IPConnection.unsignedByte(bb.get());

				for(AsyncFileWriteListener listener: listenerAsyncFileWrite) {
					listener.asyncFileWrite(fileId, errorCode, lengthWritten);
				}
			}
		};

		callbacks[CALLBACK_FILE_EVENTS_OCCURRED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int fileId = IPConnection.unsignedShort(bb.getShort());
				int events = IPConnection.unsignedShort(bb.getShort());

				for(FileEventsOccurredListener listener: listenerFileEventsOccurred) {
					listener.fileEventsOccurred(fileId, events);
				}
			}
		};

		callbacks[CALLBACK_PROCESS_STATE_CHANGED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int processId = IPConnection.unsignedShort(bb.getShort());
				short state = IPConnection.unsignedByte(bb.get());
				long timestamp = (bb.getLong());
				short exitCode = IPConnection.unsignedByte(bb.get());

				for(ProcessStateChangedListener listener: listenerProcessStateChanged) {
					listener.processStateChanged(processId, state, timestamp, exitCode);
				}
			}
		};

		callbacks[CALLBACK_PROGRAM_SCHEDULER_STATE_CHANGED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int programId = IPConnection.unsignedShort(bb.getShort());

				for(ProgramSchedulerStateChangedListener listener: listenerProgramSchedulerStateChanged) {
					listener.programSchedulerStateChanged(programId);
				}
			}
		};

		callbacks[CALLBACK_PROGRAM_PROCESS_SPAWNED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int programId = IPConnection.unsignedShort(bb.getShort());

				for(ProgramProcessSpawnedListener listener: listenerProgramProcessSpawned) {
					listener.programProcessSpawned(programId);
				}
			}
		};
	}

	/**
	 * 
	 */
	public CreateSession createSession(long lifetime) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_CREATE_SESSION, this);
		bb.putInt((int)lifetime);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		CreateSession obj = new CreateSession();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.sessionId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * 
	 */
	public short expireSession(int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_EXPIRE_SESSION, this);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public void expireSessionUnchecked(int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_EXPIRE_SESSION_UNCHECKED, this);
		bb.putShort((short)sessionId);

		sendRequest(bb.array());
	}

	/**
	 * 
	 */
	public short keepSessionAlive(int sessionId, long lifetime) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)14, FUNCTION_KEEP_SESSION_ALIVE, this);
		bb.putShort((short)sessionId);
		bb.putInt((int)lifetime);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * Decreases the reference count of an object by one and returns the resulting
	 * error code. If the reference count reaches zero the object gets destroyed.
	 */
	public short releaseObject(int objectId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_RELEASE_OBJECT, this);
		bb.putShort((short)objectId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public void releaseObjectUnchecked(int objectId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_RELEASE_OBJECT_UNCHECKED, this);
		bb.putShort((short)objectId);
		bb.putShort((short)sessionId);

		sendRequest(bb.array());
	}

	/**
	 * Allocates a new string object, reserves ``length_to_reserve`` bytes memory
	 * for it and sets up to the first 60 bytes. Set ``length_to_reserve`` to the
	 * length of the string that should be stored in the string object.
	 * 
	 * Returns the object ID of the new string object and the resulting error code.
	 */
	public AllocateString allocateString(long lengthToReserve, String buffer, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)72, FUNCTION_ALLOCATE_STRING, this);
		bb.putInt((int)lengthToReserve);
		for(int i = 0; i < 58; i++) {
			try {
				bb.put((byte)buffer.charAt(i));
			} catch(Exception e) {
				bb.put((byte)0);
			}
		}

		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		AllocateString obj = new AllocateString();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.stringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Truncates a string object to ``length`` bytes and returns the resulting
	 * error code.
	 */
	public short truncateString(int stringId, long length) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)14, FUNCTION_TRUNCATE_STRING, this);
		bb.putShort((short)stringId);
		bb.putInt((int)length);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * Returns the length of a string object in bytes and the resulting error code.
	 */
	public StringLength getStringLength(int stringId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_GET_STRING_LENGTH, this);
		bb.putShort((short)stringId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		StringLength obj = new StringLength();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.length = IPConnection.unsignedInt(bb.getInt());

		return obj;
	}

	/**
	 * Sets a chunk of up to 58 bytes in a string object beginning at ``offset``.
	 * 
	 * Returns the resulting error code.
	 */
	public short setStringChunk(int stringId, long offset, String buffer) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)72, FUNCTION_SET_STRING_CHUNK, this);
		bb.putShort((short)stringId);
		bb.putInt((int)offset);
		for(int i = 0; i < 58; i++) {
			try {
				bb.put((byte)buffer.charAt(i));
			} catch(Exception e) {
				bb.put((byte)0);
			}
		}


		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * Returns a chunk up to 63 bytes from a string object beginning at ``offset`` and
	 * returns the resulting error code.
	 */
	public StringChunk getStringChunk(int stringId, long offset) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)14, FUNCTION_GET_STRING_CHUNK, this);
		bb.putShort((short)stringId);
		bb.putInt((int)offset);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		StringChunk obj = new StringChunk();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.buffer = IPConnection.string(bb, 63);

		return obj;
	}

	/**
	 * Allocates a new list object and reserves memory for ``length_to_reserve``
	 * items. Set ``length_to_reserve`` to the number of items that should be stored
	 * in the list object.
	 * 
	 * Returns the object ID of the new list object and the resulting error code.
	 * 
	 * When a list object gets destroyed then the reference count of each object in
	 * the list object is decreased by one.
	 */
	public AllocateList allocateList(int lengthToReserve, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_ALLOCATE_LIST, this);
		bb.putShort((short)lengthToReserve);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		AllocateList obj = new AllocateList();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.listId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Returns the length of a list object in items and the resulting error code.
	 */
	public ListLength getListLength(int listId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_GET_LIST_LENGTH, this);
		bb.putShort((short)listId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ListLength obj = new ListLength();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.length = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Returns the object ID and type of the object stored at ``index`` in a list
	 * object and returns the resulting error code.
	 * 
	 * Possible object types are:
	 * 
	 * * String = 0
	 * * List = 1
	 * * File = 2
	 * * Directory = 3
	 * * Process = 4
	 * * Program = 5
	 */
	public ListItem getListItem(int listId, int index, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)14, FUNCTION_GET_LIST_ITEM, this);
		bb.putShort((short)listId);
		bb.putShort((short)index);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ListItem obj = new ListItem();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.itemObjectId = IPConnection.unsignedShort(bb.getShort());
		obj.type = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Appends an object to a list object and increases the reference count of the
	 * appended object by one.
	 * 
	 * Returns the resulting error code.
	 */
	public short appendToList(int listId, int itemObjectId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_APPEND_TO_LIST, this);
		bb.putShort((short)listId);
		bb.putShort((short)itemObjectId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * Removes the object stored at ``index`` from a list object and decreases the
	 * reference count of the removed object by one.
	 * 
	 * Returns the resulting error code.
	 */
	public short removeFromList(int listId, int index) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_REMOVE_FROM_LIST, this);
		bb.putShort((short)listId);
		bb.putShort((short)index);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * Opens an existing file or creates a new file and allocates a new file object
	 * for it.
	 * 
	 * FIXME: name has to be absolute
	 * 
	 * The reference count of the name string object is increased by one. When the
	 * file object gets destroyed then the reference count of the name string object is
	 * decreased by one. Also the name string object is locked and cannot be modified
	 * while the file object holds a reference to it.
	 * 
	 * The ``flags`` parameter takes a ORed combination of the following possible file
	 * flags (in hexadecimal notation):
	 * 
	 * * ReadOnly = 0x0001 (O_RDONLY)
	 * * WriteOnly = 0x0002 (O_WRONLY)
	 * * ReadWrite = 0x0004 (O_RDWR)
	 * * Append = 0x0008 (O_APPEND)
	 * * Create = 0x0010 (O_CREAT)
	 * * Exclusive = 0x0020 (O_EXCL)
	 * * NonBlocking = 0x0040 (O_NONBLOCK)
	 * * Truncate = 0x0080 (O_TRUNC)
	 * * Temporary = 0x0100
	 * * Replace = 0x0200
	 * 
	 * FIXME: explain *Temporary* and *Replace* flag
	 * 
	 * The ``permissions`` parameter takes a ORed combination of the following
	 * possible file permissions (in octal notation) that match the common UNIX
	 * permission bits:
	 * 
	 * * UserRead = 00400
	 * * UserWrite = 00200
	 * * UserExecute = 00100
	 * * GroupRead = 00040
	 * * GroupWrite = 00020
	 * * GroupExecute = 00010
	 * * OthersRead = 00004
	 * * OthersWrite = 00002
	 * * OthersExecute = 00001
	 * 
	 * Returns the object ID of the new file object and the resulting error code.
	 */
	public OpenFile openFile(int nameStringId, long flags, int permissions, long uid, long gid, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)26, FUNCTION_OPEN_FILE, this);
		bb.putShort((short)nameStringId);
		bb.putInt((int)flags);
		bb.putShort((short)permissions);
		bb.putInt((int)uid);
		bb.putInt((int)gid);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		OpenFile obj = new OpenFile();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.fileId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Creates a new pipe and allocates a new file object for it.
	 * 
	 * The ``flags`` parameter takes a ORed combination of the following possible
	 * pipe flags (in hexadecimal notation):
	 * 
	 * * NonBlockingRead = 0x0001
	 * * NonBlockingWrite = 0x0002
	 * 
	 * The length of the pipe buffer can be specified with the ``length`` parameter
	 * in bytes. If length is set to zero, then the default pipe buffer length is used.
	 * 
	 * Returns the object ID of the new file object and the resulting error code.
	 */
	public CreatePipe createPipe(long flags, long length, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)22, FUNCTION_CREATE_PIPE, this);
		bb.putInt((int)flags);
		bb.putLong(length);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		CreatePipe obj = new CreatePipe();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.fileId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Returns various information about a file and the resulting error code.
	 * 
	 * Possible file types are:
	 * 
	 * * Unknown = 0
	 * * Regular = 1
	 * * Directory = 2
	 * * Character = 3
	 * * Block = 4
	 * * FIFO = 5
	 * * Symlink = 6
	 * * Socket = 7
	 * * Pipe = 8
	 * 
	 * If the file type is *Pipe* then the returned name string object is invalid,
	 * because a pipe has no name. Otherwise the returned name string object was used
	 * to open or create the file object, as passed to {@link BrickRED#openFile(int, long, int, long, long, int)}.
	 * 
	 * The returned flags were used to open or create the file object, as passed to
	 * {@link BrickRED#openFile(int, long, int, long, long, int)} or {@link BrickRED#createPipe(long, long, int)}. See the respective function for a list
	 * of possible file and pipe flags.
	 * 
	 * FIXME: everything except flags and length is invalid if file type is *Pipe*
	 */
	public FileInfo getFileInfo(int fileId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_FILE_INFO, this);
		bb.putShort((short)fileId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		FileInfo obj = new FileInfo();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.type = IPConnection.unsignedByte(bb.get());
		obj.nameStringId = IPConnection.unsignedShort(bb.getShort());
		obj.flags = IPConnection.unsignedInt(bb.getInt());
		obj.permissions = IPConnection.unsignedShort(bb.getShort());
		obj.uid = IPConnection.unsignedInt(bb.getInt());
		obj.gid = IPConnection.unsignedInt(bb.getInt());
		obj.length = (bb.getLong());
		obj.accessTimestamp = (bb.getLong());
		obj.modificationTimestamp = (bb.getLong());
		obj.statusChangeTimestamp = (bb.getLong());

		return obj;
	}

	/**
	 * Reads up to 62 bytes from a file object.
	 * 
	 * Returns the bytes read, the actual number of bytes read and the resulting
	 * error code.
	 * 
	 * If there is not data to be read, either because the file position reached
	 * end-of-file or because there is not data in the pipe, then zero bytes are
	 * returned.
	 * 
	 * If the file object was created by {@link BrickRED#openFile(int, long, int, long, long, int)} without the *NonBlocking*
	 * flag or by {@link BrickRED#createPipe(long, long, int)} without the *NonBlockingRead* flag then the
	 * error code *NotSupported* is returned.
	 */
	public ReadFile readFile(int fileId, short lengthToRead) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)11, FUNCTION_READ_FILE, this);
		bb.putShort((short)fileId);
		bb.put((byte)lengthToRead);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ReadFile obj = new ReadFile();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		for(int i = 0; i < 62; i++) {
			obj.buffer[i] = IPConnection.unsignedByte(bb.get());
		}

		obj.lengthRead = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Reads up to 2\ :sup:`63`\  - 1 bytes from a file object asynchronously.
	 * 
	 * Reports the bytes read (in 60 byte chunks), the actual number of bytes read and
	 * the resulting error code via the {@link BrickRED.AsyncFileReadListener} listener.
	 * 
	 * If there is not data to be read, either because the file position reached
	 * end-of-file or because there is not data in the pipe, then zero bytes are
	 * reported.
	 * 
	 * If the file object was created by {@link BrickRED#openFile(int, long, int, long, long, int)} without the *NonBlocking*
	 * flag or by {@link BrickRED#createPipe(long, long, int)} without the *NonBlockingRead* flag then the error
	 * code *NotSupported* is reported via the {@link BrickRED.AsyncFileReadListener} listener.
	 */
	public void readFileAsync(int fileId, long lengthToRead) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)18, FUNCTION_READ_FILE_ASYNC, this);
		bb.putShort((short)fileId);
		bb.putLong(lengthToRead);

		sendRequest(bb.array());
	}

	/**
	 * Aborts a {@link BrickRED#readFileAsync(int, long)} operation in progress.
	 * 
	 * Returns the resulting error code.
	 * 
	 * On success the {@link BrickRED.AsyncFileReadListener} listener will report *OperationAborted*.
	 */
	public short abortAsyncFileRead(int fileId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_ABORT_ASYNC_FILE_READ, this);
		bb.putShort((short)fileId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * Writes up to 61 bytes to a file object.
	 * 
	 * Returns the actual number of bytes written and the resulting error code.
	 * 
	 * If the file object was created by {@link BrickRED#openFile(int, long, int, long, long, int)} without the *NonBlocking*
	 * flag or by {@link BrickRED#createPipe(long, long, int)} without the *NonBlockingWrite* flag then the
	 * error code *NotSupported* is returned.
	 */
	public WriteFile writeFile(int fileId, short[] buffer, short lengthToWrite) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)72, FUNCTION_WRITE_FILE, this);
		bb.putShort((short)fileId);
		for(int i = 0; i < 61; i++) {
			bb.put((byte)buffer[i]);
		}

		bb.put((byte)lengthToWrite);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		WriteFile obj = new WriteFile();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.lengthWritten = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Writes up to 61 bytes to a file object.
	 * 
	 * Does neither report the actual number of bytes written nor the resulting error
	 * code.
	 * 
	 * If the file object was created by {@link BrickRED#openFile(int, long, int, long, long, int)} without the *NonBlocking*
	 * flag or by {@link BrickRED#createPipe(long, long, int)} without the *NonBlockingWrite* flag then the
	 * write operation will fail silently.
	 */
	public void writeFileUnchecked(int fileId, short[] buffer, short lengthToWrite) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)72, FUNCTION_WRITE_FILE_UNCHECKED, this);
		bb.putShort((short)fileId);
		for(int i = 0; i < 61; i++) {
			bb.put((byte)buffer[i]);
		}

		bb.put((byte)lengthToWrite);

		sendRequest(bb.array());
	}

	/**
	 * Writes up to 61 bytes to a file object.
	 * 
	 * Reports the actual number of bytes written and the resulting error code via the
	 * {@link BrickRED.AsyncFileWriteListener} listener.
	 * 
	 * If the file object was created by {@link BrickRED#openFile(int, long, int, long, long, int)} without the *NonBlocking*
	 * flag or by {@link BrickRED#createPipe(long, long, int)} without the *NonBlockingWrite* flag then the
	 * error code *NotSupported* is reported via the {@link BrickRED.AsyncFileWriteListener} listener.
	 */
	public void writeFileAsync(int fileId, short[] buffer, short lengthToWrite) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)72, FUNCTION_WRITE_FILE_ASYNC, this);
		bb.putShort((short)fileId);
		for(int i = 0; i < 61; i++) {
			bb.put((byte)buffer[i]);
		}

		bb.put((byte)lengthToWrite);

		sendRequest(bb.array());
	}

	/**
	 * Set the current seek position of a file object in bytes relative to ``origin``.
	 * 
	 * Possible file origins are:
	 * 
	 * * Beginning = 0
	 * * Current = 1
	 * * End = 2
	 * 
	 * Returns the resulting absolute seek position and error code.
	 * 
	 * If the file object was created by {@link BrickRED#createPipe(long, long, int)} then it has no seek
	 * position and the error code *InvalidSeek* is returned.
	 */
	public SetFilePosition setFilePosition(int fileId, long offset, short origin) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)19, FUNCTION_SET_FILE_POSITION, this);
		bb.putShort((short)fileId);
		bb.putLong(offset);
		bb.put((byte)origin);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		SetFilePosition obj = new SetFilePosition();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.position = (bb.getLong());

		return obj;
	}

	/**
	 * Returns the current seek position of a file object in bytes and returns the
	 * resulting error code.
	 * 
	 * If the file object was created by {@link BrickRED#createPipe(long, long, int)} then it has no seek
	 * position and the error code *InvalidSeek* is returned.
	 */
	public FilePosition getFilePosition(int fileId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_GET_FILE_POSITION, this);
		bb.putShort((short)fileId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		FilePosition obj = new FilePosition();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.position = (bb.getLong());

		return obj;
	}

	/**
	 * 
	 */
	public short setFileEvents(int fileId, int events) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_FILE_EVENTS, this);
		bb.putShort((short)fileId);
		bb.putShort((short)events);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public FileEvents getFileEvents(int fileId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_GET_FILE_EVENTS, this);
		bb.putShort((short)fileId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		FileEvents obj = new FileEvents();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.events = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Opens an existing directory and allocates a new directory object for it.
	 * 
	 * FIXME: name has to be absolute
	 * 
	 * The reference count of the name string object is increased by one. When the
	 * directory object is destroyed then the reference count of the name string
	 * object is decreased by one. Also the name string object is locked and cannot be
	 * modified while the directory object holds a reference to it.
	 * 
	 * Returns the object ID of the new directory object and the resulting error code.
	 */
	public OpenDirectory openDirectory(int nameStringId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_OPEN_DIRECTORY, this);
		bb.putShort((short)nameStringId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		OpenDirectory obj = new OpenDirectory();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.directoryId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Returns the name of a directory object, as passed to {@link BrickRED#openDirectory(int, int)}, and
	 * the resulting error code.
	 */
	public DirectoryName getDirectoryName(int directoryId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_DIRECTORY_NAME, this);
		bb.putShort((short)directoryId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		DirectoryName obj = new DirectoryName();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.nameStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Returns the next entry in a directory object and the resulting error code.
	 * 
	 * If there is not next entry then error code *NoMoreData* is returned. To rewind
	 * a directory object call {@link BrickRED#rewindDirectory(int)}.
	 * 
	 * Possible directory entry types are:
	 * 
	 * * Unknown = 0
	 * * Regular = 1
	 * * Directory = 2
	 * * Character = 3
	 * * Block = 4
	 * * FIFO = 5
	 * * Symlink = 6
	 * * Socket = 7
	 */
	public NextDirectoryEntry getNextDirectoryEntry(int directoryId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_NEXT_DIRECTORY_ENTRY, this);
		bb.putShort((short)directoryId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		NextDirectoryEntry obj = new NextDirectoryEntry();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.nameStringId = IPConnection.unsignedShort(bb.getShort());
		obj.type = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Rewinds a directory object and returns the resulting error code.
	 */
	public short rewindDirectory(int directoryId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_REWIND_DIRECTORY, this);
		bb.putShort((short)directoryId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * FIXME: name has to be absolute
	 */
	public short createDirectory(int nameStringId, long flags, int permissions, long uid, long gid) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)24, FUNCTION_CREATE_DIRECTORY, this);
		bb.putShort((short)nameStringId);
		bb.putInt((int)flags);
		bb.putShort((short)permissions);
		bb.putInt((int)uid);
		bb.putInt((int)gid);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public Processes getProcesses(int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_GET_PROCESSES, this);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Processes obj = new Processes();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.processesListId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * 
	 */
	public SpawnProcess spawnProcess(int executableStringId, int argumentsListId, int environmentListId, int workingDirectoryStringId, long uid, long gid, int stdinFileId, int stdoutFileId, int stderrFileId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)32, FUNCTION_SPAWN_PROCESS, this);
		bb.putShort((short)executableStringId);
		bb.putShort((short)argumentsListId);
		bb.putShort((short)environmentListId);
		bb.putShort((short)workingDirectoryStringId);
		bb.putInt((int)uid);
		bb.putInt((int)gid);
		bb.putShort((short)stdinFileId);
		bb.putShort((short)stdoutFileId);
		bb.putShort((short)stderrFileId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		SpawnProcess obj = new SpawnProcess();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.processId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sends a UNIX signal to a process object and returns the resulting error code.
	 * 
	 * Possible UNIX signals are:
	 * 
	 * * Interrupt = 2
	 * * Quit = 3
	 * * Abort = 6
	 * * Kill = 9
	 * * User1 = 10
	 * * User2 = 12
	 * * Terminate = 15
	 * * Continue =  18
	 * * Stop = 19
	 */
	public short killProcess(int processId, short signal) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)11, FUNCTION_KILL_PROCESS, this);
		bb.putShort((short)processId);
		bb.put((byte)signal);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * Returns the executable, arguments, environment and working directory used to
	 * spawn a process object, as passed to {@link BrickRED#spawnProcess(int, int, int, int, long, long, int, int, int, int)}, and the resulting
	 * error code.
	 */
	public ProcessCommand getProcessCommand(int processId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_PROCESS_COMMAND, this);
		bb.putShort((short)processId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProcessCommand obj = new ProcessCommand();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.executableStringId = IPConnection.unsignedShort(bb.getShort());
		obj.argumentsListId = IPConnection.unsignedShort(bb.getShort());
		obj.environmentListId = IPConnection.unsignedShort(bb.getShort());
		obj.workingDirectoryStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Returns the process ID and the user and group ID used to spawn a process object,
	 * as passed to {@link BrickRED#spawnProcess(int, int, int, int, long, long, int, int, int, int)}, and the resulting error code.
	 * 
	 * The process ID is only valid if the state is *Running* or *Stopped*, see
	 * {@link BrickRED#getProcessState(int)}.
	 */
	public ProcessIdentity getProcessIdentity(int processId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_GET_PROCESS_IDENTITY, this);
		bb.putShort((short)processId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProcessIdentity obj = new ProcessIdentity();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.pid = IPConnection.unsignedInt(bb.getInt());
		obj.uid = IPConnection.unsignedInt(bb.getInt());
		obj.gid = IPConnection.unsignedInt(bb.getInt());

		return obj;
	}

	/**
	 * Returns the stdin, stdout and stderr files used to spawn a process object, as
	 * passed to {@link BrickRED#spawnProcess(int, int, int, int, long, long, int, int, int, int)}, and the resulting error code.
	 */
	public ProcessStdio getProcessStdio(int processId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_PROCESS_STDIO, this);
		bb.putShort((short)processId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProcessStdio obj = new ProcessStdio();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.stdinFileId = IPConnection.unsignedShort(bb.getShort());
		obj.stdoutFileId = IPConnection.unsignedShort(bb.getShort());
		obj.stderrFileId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Returns the current state, timestamp and exit code of a process object, and
	 * the resulting error code.
	 * 
	 * Possible process states are:
	 * 
	 * * Unknown = 0
	 * * Running = 1
	 * * Error = 2
	 * * Exited = 3
	 * * Killed = 4
	 * * Stopped = 5
	 * 
	 * The timestamp represents the UNIX time since when the process is in its current
	 * state.
	 * 
	 * The exit code is only valid if the state is *Error*, *Exited*, *Killed* or
	 * *Stopped* and has different meanings depending on the state:
	 * 
	 * * Error: error code for error occurred while spawning the process (see below)
	 * * Exited: exit status of the process
	 * * Killed: UNIX signal number used to kill the process
	 * * Stopped: UNIX signal number used to stop the process
	 * 
	 * Possible exit/error codes in *Error* state are:
	 * 
	 * * InternalError = 125
	 * * CannotExecute = 126
	 * * DoesNotExist = 127
	 * 
	 * The *CannotExecute* error can be caused by the executable being opened for
	 * writing.
	 */
	public ProcessState getProcessState(int processId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_GET_PROCESS_STATE, this);
		bb.putShort((short)processId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProcessState obj = new ProcessState();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.state = IPConnection.unsignedByte(bb.get());
		obj.timestamp = (bb.getLong());
		obj.exitCode = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * 
	 */
	public Programs getPrograms(int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_GET_PROGRAMS, this);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Programs obj = new Programs();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.programsListId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * 
	 */
	public DefineProgram defineProgram(int identifierStringId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_DEFINE_PROGRAM, this);
		bb.putShort((short)identifierStringId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		DefineProgram obj = new DefineProgram();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.programId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * 
	 */
	public short purgeProgram(int programId, long cookie) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)14, FUNCTION_PURGE_PROGRAM, this);
		bb.putShort((short)programId);
		bb.putInt((int)cookie);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public ProgramIdentifier getProgramIdentifier(int programId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_PROGRAM_IDENTIFIER, this);
		bb.putShort((short)programId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProgramIdentifier obj = new ProgramIdentifier();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.identifierStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * FIXME: root directory is absolute: &lt;home&gt;/programs/&lt;identifier&gt;
	 */
	public ProgramRootDirectory getProgramRootDirectory(int programId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_PROGRAM_ROOT_DIRECTORY, this);
		bb.putShort((short)programId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProgramRootDirectory obj = new ProgramRootDirectory();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.rootDirectoryStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * FIXME: working directory is relative to &lt;home&gt;/programs/&lt;identifier&gt;/bin
	 */
	public short setProgramCommand(int programId, int executableStringId, int argumentsListId, int environmentListId, int workingDirectoryStringId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)18, FUNCTION_SET_PROGRAM_COMMAND, this);
		bb.putShort((short)programId);
		bb.putShort((short)executableStringId);
		bb.putShort((short)argumentsListId);
		bb.putShort((short)environmentListId);
		bb.putShort((short)workingDirectoryStringId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * FIXME: working directory is relative to &lt;home&gt;/programs/&lt;identifier&gt;/bin
	 */
	public ProgramCommand getProgramCommand(int programId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_PROGRAM_COMMAND, this);
		bb.putShort((short)programId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProgramCommand obj = new ProgramCommand();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.executableStringId = IPConnection.unsignedShort(bb.getShort());
		obj.argumentsListId = IPConnection.unsignedShort(bb.getShort());
		obj.environmentListId = IPConnection.unsignedShort(bb.getShort());
		obj.workingDirectoryStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * FIXME: stdio file names are relative to &lt;home&gt;/programs/&lt;identifier&gt;/bin
	 */
	public short setProgramStdioRedirection(int programId, short stdinRedirection, int stdinFileNameStringId, short stdoutRedirection, int stdoutFileNameStringId, short stderrRedirection, int stderrFileNameStringId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)19, FUNCTION_SET_PROGRAM_STDIO_REDIRECTION, this);
		bb.putShort((short)programId);
		bb.put((byte)stdinRedirection);
		bb.putShort((short)stdinFileNameStringId);
		bb.put((byte)stdoutRedirection);
		bb.putShort((short)stdoutFileNameStringId);
		bb.put((byte)stderrRedirection);
		bb.putShort((short)stderrFileNameStringId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * FIXME: stdio file names are relative to &lt;home&gt;/programs/&lt;identifier&gt;/bin
	 */
	public ProgramStdioRedirection getProgramStdioRedirection(int programId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_PROGRAM_STDIO_REDIRECTION, this);
		bb.putShort((short)programId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProgramStdioRedirection obj = new ProgramStdioRedirection();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.stdinRedirection = IPConnection.unsignedByte(bb.get());
		obj.stdinFileNameStringId = IPConnection.unsignedShort(bb.getShort());
		obj.stdoutRedirection = IPConnection.unsignedByte(bb.get());
		obj.stdoutFileNameStringId = IPConnection.unsignedShort(bb.getShort());
		obj.stderrRedirection = IPConnection.unsignedByte(bb.get());
		obj.stderrFileNameStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * 
	 */
	public short setProgramSchedule(int programId, short startMode, boolean continueAfterError, long startInterval, int startFieldsStringId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)18, FUNCTION_SET_PROGRAM_SCHEDULE, this);
		bb.putShort((short)programId);
		bb.put((byte)startMode);
		bb.put((byte)(continueAfterError ? 1 : 0));
		bb.putInt((int)startInterval);
		bb.putShort((short)startFieldsStringId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public ProgramSchedule getProgramSchedule(int programId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_PROGRAM_SCHEDULE, this);
		bb.putShort((short)programId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProgramSchedule obj = new ProgramSchedule();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.startMode = IPConnection.unsignedByte(bb.get());
		obj.continueAfterError = (bb.get()) != 0;
		obj.startInterval = IPConnection.unsignedInt(bb.getInt());
		obj.startFieldsStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * FIXME: message is currently valid in error-occurred state only
	 */
	public ProgramSchedulerState getProgramSchedulerState(int programId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_PROGRAM_SCHEDULER_STATE, this);
		bb.putShort((short)programId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ProgramSchedulerState obj = new ProgramSchedulerState();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.state = IPConnection.unsignedByte(bb.get());
		obj.timestamp = (bb.getLong());
		obj.messageStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * 
	 */
	public short continueProgramSchedule(int programId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_CONTINUE_PROGRAM_SCHEDULE, this);
		bb.putShort((short)programId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public short startProgram(int programId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_START_PROGRAM, this);
		bb.putShort((short)programId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public LastSpawnedProgramProcess getLastSpawnedProgramProcess(int programId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_LAST_SPAWNED_PROGRAM_PROCESS, this);
		bb.putShort((short)programId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		LastSpawnedProgramProcess obj = new LastSpawnedProgramProcess();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.processId = IPConnection.unsignedShort(bb.getShort());
		obj.timestamp = (bb.getLong());

		return obj;
	}

	/**
	 * 
	 */
	public CustomProgramOptionNames getCustomProgramOptionNames(int programId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_GET_CUSTOM_PROGRAM_OPTION_NAMES, this);
		bb.putShort((short)programId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		CustomProgramOptionNames obj = new CustomProgramOptionNames();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.namesListId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * 
	 */
	public short setCustomProgramOptionValue(int programId, int nameStringId, int valueStringId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)14, FUNCTION_SET_CUSTOM_PROGRAM_OPTION_VALUE, this);
		bb.putShort((short)programId);
		bb.putShort((short)nameStringId);
		bb.putShort((short)valueStringId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * 
	 */
	public CustomProgramOptionValue getCustomProgramOptionValue(int programId, int nameStringId, int sessionId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)14, FUNCTION_GET_CUSTOM_PROGRAM_OPTION_VALUE, this);
		bb.putShort((short)programId);
		bb.putShort((short)nameStringId);
		bb.putShort((short)sessionId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		CustomProgramOptionValue obj = new CustomProgramOptionValue();
		obj.errorCode = IPConnection.unsignedByte(bb.get());
		obj.valueStringId = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * 
	 */
	public short removeCustomProgramOption(int programId, int nameStringId) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_REMOVE_CUSTOM_PROGRAM_OPTION, this);
		bb.putShort((short)programId);
		bb.putShort((short)nameStringId);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short errorCode = IPConnection.unsignedByte(bb.get());

		return errorCode;
	}

	/**
	 * Returns the UID, the UID where the Brick is connected to, 
	 * the position, the hardware and firmware version as well as the
	 * device identifier.
	 * 
	 * The position can be '0'-'8' (stack position).
	 * 
	 * The device identifier numbers can be found :ref:`here &lt;device_identifier&gt;`.
	 * |device_identifier_constant|
	 */
	public Identity getIdentity() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_IDENTITY, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Identity obj = new Identity();
		obj.uid = IPConnection.string(bb, 8);
		obj.connectedUid = IPConnection.string(bb, 8);
		obj.position = (char)(bb.get());
		for(int i = 0; i < 3; i++) {
			obj.hardwareVersion[i] = IPConnection.unsignedByte(bb.get());
		}

		for(int i = 0; i < 3; i++) {
			obj.firmwareVersion[i] = IPConnection.unsignedByte(bb.get());
		}

		obj.deviceIdentifier = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Adds a AsyncFileRead listener.
	 */
	public void addAsyncFileReadListener(AsyncFileReadListener listener) {
		listenerAsyncFileRead.add(listener);
	}

	/**
	 * Removes a AsyncFileRead listener.
	 */
	public void removeAsyncFileReadListener(AsyncFileReadListener listener) {
		listenerAsyncFileRead.remove(listener);
	}

	/**
	 * Adds a AsyncFileWrite listener.
	 */
	public void addAsyncFileWriteListener(AsyncFileWriteListener listener) {
		listenerAsyncFileWrite.add(listener);
	}

	/**
	 * Removes a AsyncFileWrite listener.
	 */
	public void removeAsyncFileWriteListener(AsyncFileWriteListener listener) {
		listenerAsyncFileWrite.remove(listener);
	}

	/**
	 * Adds a FileEventsOccurred listener.
	 */
	public void addFileEventsOccurredListener(FileEventsOccurredListener listener) {
		listenerFileEventsOccurred.add(listener);
	}

	/**
	 * Removes a FileEventsOccurred listener.
	 */
	public void removeFileEventsOccurredListener(FileEventsOccurredListener listener) {
		listenerFileEventsOccurred.remove(listener);
	}

	/**
	 * Adds a ProcessStateChanged listener.
	 */
	public void addProcessStateChangedListener(ProcessStateChangedListener listener) {
		listenerProcessStateChanged.add(listener);
	}

	/**
	 * Removes a ProcessStateChanged listener.
	 */
	public void removeProcessStateChangedListener(ProcessStateChangedListener listener) {
		listenerProcessStateChanged.remove(listener);
	}

	/**
	 * Adds a ProgramSchedulerStateChanged listener.
	 */
	public void addProgramSchedulerStateChangedListener(ProgramSchedulerStateChangedListener listener) {
		listenerProgramSchedulerStateChanged.add(listener);
	}

	/**
	 * Removes a ProgramSchedulerStateChanged listener.
	 */
	public void removeProgramSchedulerStateChangedListener(ProgramSchedulerStateChangedListener listener) {
		listenerProgramSchedulerStateChanged.remove(listener);
	}

	/**
	 * Adds a ProgramProcessSpawned listener.
	 */
	public void addProgramProcessSpawnedListener(ProgramProcessSpawnedListener listener) {
		listenerProgramProcessSpawned.add(listener);
	}

	/**
	 * Removes a ProgramProcessSpawned listener.
	 */
	public void removeProgramProcessSpawnedListener(ProgramProcessSpawnedListener listener) {
		listenerProgramProcessSpawned.remove(listener);
	}
}
