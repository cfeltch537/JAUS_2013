package src.urn_jaus_jss_core_AccessControl_1_0.InternalEvents;

import framework.internalEvents.InternalEvent;
import framework.JausUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.logging.Logger;
import java.util.logging.Level;

public class BroadcastGlobal extends InternalEvent
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static class  Body
	{
		public static class  SendRec
		{
			public static class  MessagePayload
			{
			
				protected SendRec m_parent;
				protected long m_Length;
				protected ByteBuffer m_Data;
			
				public void setParent(SendRec parent)
				{
					m_parent = parent;
				}
				
				public void setParentPresenceVector()
				{
					if(m_parent != null )
					{
						m_parent.setParentPresenceVector();
					}
				}
				
				public long getLength()
				{
					return m_Length;
				}
				
				public ByteBuffer getData()
				{
					m_Data.rewind();
					ByteBuffer ret = ByteBuffer.allocate(m_Data.array().length);
					ret.order(ByteOrder.LITTLE_ENDIAN);
					ret.put(m_Data);
					return ret;
				}
				
				public void set(long length, ByteBuffer data)
				{
					m_Length = length;
					
					m_Data.clear();
					
					if (m_Length > 0)
					{
						data.rewind();
						m_Data = ByteBuffer.allocate(data.array().length);
						m_Data.order(ByteOrder.LITTLE_ENDIAN);
						m_Data.put(data);
					}
					
					setParentPresenceVector();
				}
				
				/**
				 * Returns the number of bytes the used data members of the class occupies
				 * in the buffer. This is not the number of bytes the data type occupies in 
				 * Java, but the bytes expected on the wire.
				 * 
				 * @return
				 */
				public long getSize()
				{
					long size = 0;
					
					size += JausUtils.getNumBytes("int");
					size += m_Length;
					
					return size;
				}
				
				public void encode(ByteBuffer bytes, int pos)
				{
					
					if (bytes.array() == null)
					{
						return;
					}
					
					if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
					{
						bytes.order(ByteOrder.LITTLE_ENDIAN);
					}
					
					
					bytes.putInt(pos, (int) m_Length);
					pos += JausUtils.getNumBytes("int");
					
					byte[] byteArray = m_Data.array();
					
					for(int i = 0; i<(int) m_Length; i++)
					{
						bytes.put(pos, byteArray[i]);
						pos++;
					}
					
				}
				
				public void decode(ByteBuffer bytes, int pos)
				{
					
					if (bytes.array() == null)
					{
						return;
					}
					if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
					{
						bytes.order(ByteOrder.LITTLE_ENDIAN);
					}
					
					
					m_Length = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
					byte[] byteArray = new byte[(int)m_Length];
					
					int i;
					for(i=0; i<(int) m_Length; i++)
					{
						byteArray[i] = bytes.get(pos);
						pos++;
					}
					
					m_Data = ByteBuffer.allocate((int)m_Length).order(ByteOrder.LITTLE_ENDIAN);
					m_Data.put(byteArray);
				}
				
				public BroadcastGlobal.Body.SendRec.MessagePayload assign(MessagePayload value)
				{
					this.m_Length = value.m_Length;
					
					m_Data.clear();
					
					if (m_Length > 0)
					{
						this.m_Data.put(value.m_Data);
					}
					
					return this;
				}
				
				public boolean isEqual(MessagePayload value)
				{
					if (this.m_Length != value.getLength())
					{
						return false;
					}
					
					if ((this.m_Data != null) && (value.m_Data!= null))
					{
						if(!Arrays.equals(this.m_Data.array(), value.m_Data.array()))
						{
							return false;
						}
					}
					// This case should never be true since it should not be possible
					// for the two variables to have equal lengths but one has no data.
					// This check is placed here as a secondary check.
					else if ((this.m_Data != null) || (value.m_Data != null))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(MessagePayload value)
				{
					return !this.isEqual(value);
				}
				
				public MessagePayload()
				{
					m_parent = null;
					m_Length = MAX_JTS_MESSAGE_SIZE;
					m_Data = ByteBuffer.allocate((int)m_Length);
					m_Data.order(ByteOrder.LITTLE_ENDIAN); 
				}
				
				public MessagePayload(MessagePayload value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_Length = MAX_JTS_MESSAGE_SIZE;
					m_Data = ByteBuffer.allocate((int)m_Length);
					m_Data.order(ByteOrder.LITTLE_ENDIAN); 
					
					/// Copy the values
					this.m_Length = value.m_Length;
					
					m_Data.clear();
					
					if (m_Length > 0)
					{
						this.m_Data.put(value.m_Data);
					}
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected BitSet m_PresenceVector;
			protected short m_PresenceVectorTemp;
			protected int m_DestSubsystemID;
			protected short m_DestNodeID;
			protected short m_DestComponentID;
			protected int m_SrcSubsystemID;
			protected short m_SrcNodeID;
			protected short m_SrcComponentID;
			protected short m_Priority;
			protected MessagePayload m_MessagePayload;
		
			public void setParent(Body parent)
			{
				m_parent = parent;
			}
			
			public void setParentPresenceVector()
			{
				if(m_parent != null )
				{
					m_parent.setParentPresenceVector();
				}
			}
			
			public short getPresenceVector()
			{
				return m_PresenceVectorTemp;
			}
			
			protected void setPresenceVector(int index)
			{
				
				m_PresenceVector.set(index);
				m_PresenceVectorTemp = (short) JausUtils.getPVInt(m_PresenceVector);
			}
			
			public boolean checkPresenceVector(int index)
			{
				
				return m_PresenceVector.get(index);
			}
			
			public int getDestSubsystemID()
			{
				return m_DestSubsystemID;
			}
			
			public void setDestSubsystemID(int value)
			{
				m_DestSubsystemID = value;
				setParentPresenceVector();
			}
			
			public short getDestNodeID()
			{
				return m_DestNodeID;
			}
			
			public void setDestNodeID(short value)
			{
				m_DestNodeID = value;
				setParentPresenceVector();
			}
			
			public short getDestComponentID()
			{
				return m_DestComponentID;
			}
			
			public void setDestComponentID(short value)
			{
				m_DestComponentID = value;
				setParentPresenceVector();
			}
			
			public boolean isSrcSubsystemIDValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public int getSrcSubsystemID()
			{
				return m_SrcSubsystemID;
			}
			
			public void setSrcSubsystemID(int value)
			{
				m_SrcSubsystemID = value;
				setPresenceVector(0);
				setParentPresenceVector();
			}
			
			public boolean isSrcNodeIDValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public short getSrcNodeID()
			{
				return m_SrcNodeID;
			}
			
			public void setSrcNodeID(short value)
			{
				m_SrcNodeID = value;
				setPresenceVector(1);
				setParentPresenceVector();
			}
			
			public short getSrcComponentID()
			{
				return m_SrcComponentID;
			}
			
			public void setSrcComponentID(short value)
			{
				m_SrcComponentID = value;
				setParentPresenceVector();
			}
			
			public boolean isPriorityValid()
			{
				if (checkPresenceVector(2))
				{
					return true;
				}
				return false;
			}
			
			public short getPriority()
			{
				return m_Priority;
			}
			
			public void setPriority(short value)
			{
				if (((value >= 0) && (value <= 3)) || (value == 0) || (value == 1) || (value == 2) || (value == 3))
				{
					m_Priority = value;
					setPresenceVector(2);
					setParentPresenceVector();
				}
				return;
			}
			
			public BroadcastGlobal.Body.SendRec.MessagePayload getMessagePayload()
			{
				return m_MessagePayload;
			}
			
			public void setMessagePayload(MessagePayload value)
			{
				m_MessagePayload = value;
				setParentPresenceVector();
			}
			
			/**
			 * Returns the number of bytes the used data members of the class occupies
			 * in the buffer. This is not the number of bytes the data type occupies in 
			 * Java, but the bytes expected on the wire.
			 * 
			 * @return
			 */
			public long getSize()
			{
				long size = 0;
				
				size += JausUtils.getNumBytes("byte");
				size += JausUtils.getNumBytes("short");
				size += JausUtils.getNumBytes("byte");
				size += JausUtils.getNumBytes("byte");
				if (checkPresenceVector(0))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(1))
				{
					size += JausUtils.getNumBytes("byte");
				}
				size += JausUtils.getNumBytes("byte");
				if (checkPresenceVector(2))
				{
					size += JausUtils.getNumBytes("byte");
				}
				size += m_MessagePayload.getSize();
				
				return size;
			}
			
			public void encode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				try
				{
					short m_PresenceVectorTemp = (short) JausUtils.getPVInt(m_PresenceVector);
				bytes.put(pos, (byte) m_PresenceVectorTemp);
				pos += JausUtils.getNumBytes("byte");
				}
				catch(Exception e)
				{
					logger.log(Level.SEVERE, null, e);
				}
				bytes.putShort(pos, (short) m_DestSubsystemID);
				pos += JausUtils.getNumBytes("short");
				bytes.put(pos, (byte) m_DestNodeID);
				pos += JausUtils.getNumBytes("byte");
				bytes.put(pos, (byte) m_DestComponentID);
				pos += JausUtils.getNumBytes("byte");
				if (checkPresenceVector(0))
				{
					bytes.putShort(pos, (short) m_SrcSubsystemID);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(1))
				{
					bytes.put(pos, (byte) m_SrcNodeID);
					pos += JausUtils.getNumBytes("byte");
				}
				bytes.put(pos, (byte) m_SrcComponentID);
				pos += JausUtils.getNumBytes("byte");
				if (checkPresenceVector(2))
				{
					bytes.put(pos, (byte) m_Priority);
					pos += JausUtils.getNumBytes("byte");
				}
				m_MessagePayload.encode(bytes, pos);
				pos += m_MessagePayload.getSize();
			}
			
			public void decode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				try
				{
					short m_PresenceVectorTemp = 0;
				m_PresenceVectorTemp = (short) (bytes.get(pos) & 0xff);
				pos += JausUtils.getNumBytes("byte");
				m_PresenceVector = JausUtils.setPV(m_PresenceVectorTemp);
				}
				catch(Exception e)
				{
					logger.log(Level.SEVERE, null, e);
				}
				m_DestSubsystemID = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_DestNodeID = (short) (bytes.get(pos) & 0xff);
				pos += JausUtils.getNumBytes("byte");
				m_DestComponentID = (short) (bytes.get(pos) & 0xff);
				pos += JausUtils.getNumBytes("byte");
				if (checkPresenceVector(0))
				{
					m_SrcSubsystemID = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(1))
				{
					m_SrcNodeID = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				m_SrcComponentID = (short) (bytes.get(pos) & 0xff);
				pos += JausUtils.getNumBytes("byte");
				if (checkPresenceVector(2))
				{
					m_Priority = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				m_MessagePayload.decode(bytes, pos);
				pos += m_MessagePayload.getSize();
			}
			
			public BroadcastGlobal.Body.SendRec assign(SendRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_DestSubsystemID = value.m_DestSubsystemID;
				m_DestNodeID = value.m_DestNodeID;
				m_DestComponentID = value.m_DestComponentID;
				m_SrcSubsystemID = value.m_SrcSubsystemID;
				m_SrcNodeID = value.m_SrcNodeID;
				m_SrcComponentID = value.m_SrcComponentID;
				m_Priority = value.m_Priority;
				m_MessagePayload = value.m_MessagePayload;
				
				return this;
			}
			
			public boolean isEqual(SendRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_DestSubsystemID != value.getDestSubsystemID())
				{
					return false;
				}
				if (m_DestNodeID != value.getDestNodeID())
				{
					return false;
				}
				if (m_DestComponentID != value.getDestComponentID())
				{
					return false;
				}
				if (m_SrcSubsystemID != value.getSrcSubsystemID())
				{
					return false;
				}
				if (m_SrcNodeID != value.getSrcNodeID())
				{
					return false;
				}
				if (m_SrcComponentID != value.getSrcComponentID())
				{
					return false;
				}
				if (m_Priority != value.getPriority())
				{
					return false;
				}
				
				if (!m_MessagePayload.isEqual(value.getMessagePayload()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(SendRec value)
			{
				return !this.isEqual(value);
			}
			
			public SendRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_DestSubsystemID = 0;
				m_DestNodeID = 0;
				m_DestComponentID = 0;
				m_SrcSubsystemID = 0;
				m_SrcNodeID = 0;
				m_SrcComponentID = 0;
				m_Priority = 0;
					m_MessagePayload = new MessagePayload();
				m_MessagePayload.setParent(this);
			}
			
			public SendRec(SendRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_DestSubsystemID = 0;
				m_DestNodeID = 0;
				m_DestComponentID = 0;
				m_SrcSubsystemID = 0;
				m_SrcNodeID = 0;
				m_SrcComponentID = 0;
				m_Priority = 0;
					m_MessagePayload = new MessagePayload();
				m_MessagePayload.setParent(this);
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_DestSubsystemID = value.m_DestSubsystemID;
				m_DestNodeID = value.m_DestNodeID;
				m_DestComponentID = value.m_DestComponentID;
				m_SrcSubsystemID = value.m_SrcSubsystemID;
				m_SrcNodeID = value.m_SrcNodeID;
				m_SrcComponentID = value.m_SrcComponentID;
				m_Priority = value.m_Priority;
				m_MessagePayload = value.m_MessagePayload;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected SendRec m_SendRec;
	
		public BroadcastGlobal.Body.SendRec getSendRec()
		{
			return m_SendRec;
		}
		
		public void setSendRec(SendRec value)
		{
			m_SendRec = value;
			setParentPresenceVector();
		}
		
		public void setParentPresenceVector()
		{
			// Nothing needed here, placeholder function
		}
		
		/**
		 * Returns the number of bytes the used data members of the class occupies
		 * in the buffer. This is not the number of bytes the data type occupies in 
		 * Java, but the bytes expected on the wire.
		 * 
		 * @return
		 */
		public long getSize()
		{
			long size = 0;
			
			size += m_SendRec.getSize();
			
			return size;
		}
		
		public void encode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_SendRec.encode(bytes, pos);
			pos += m_SendRec.getSize();
		}
		
		public void decode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_SendRec.decode(bytes, pos);
			pos += m_SendRec.getSize();
		}
		
		public BroadcastGlobal.Body assign(Body value)
		{
			m_SendRec = value.m_SendRec;
			m_SendRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_SendRec.isEqual(value.getSendRec()))
			{
				return false;
			}
			/// This code is currently not supported
			return true;
		}
		
		public boolean notEquals(Body value)
		{
			return !this.isEqual(value);
		}
		
		public Body()
		{
			m_SendRec = new SendRec();
			m_SendRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_SendRec = new SendRec();
			m_SendRec.setParent(this);
			
			/// Copy the values
			m_SendRec = value.m_SendRec;
			m_SendRec.setParent(this);
			/// This code is currently not supported
		}
		
		public void finalize()
		{
		}
		
	}
	protected Body m_Body;
	public BroadcastGlobal.Body getBody()
	{
		return m_Body;
	}
	
	public int setBody(Body value)
	{
		m_Body = value;
		return 0;
	}
	
	/**
	 * Returns the number of bytes the used data members of the class occupies
	 * in the buffer. This is not the number of bytes the data type occupies in 
	 * Java, but the bytes expected on the wire.
	 * 
	 * @return
	 */
	public long getSize()
	{
		int size = 0;
		
		size += m_Body.getSize();
		
		return size;
	}
	
	public void encode(ByteBuffer bytes, int pos)
	{
		
		if (bytes.array() == null)
		{
			return;
		}
		if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
		{
			bytes.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		m_Body.encode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public void decode(ByteBuffer bytes, int pos)
	{
		
		if (bytes.array() == null)
		{
			return;
		}
		if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
		{
			bytes.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		m_Body.decode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public BroadcastGlobal setAs(BroadcastGlobal value)
	{
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(BroadcastGlobal value)
	{
		if (!m_Body.isEqual(value.getBody()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean notEquals(BroadcastGlobal value)
	{
		return !isEqual(value);
	}
	
	public BroadcastGlobal()
	{
		m_Body = new Body();
		m_Name = "BroadcastGlobal";
	}
	
	public  BroadcastGlobal(BroadcastGlobal value)
	{
		/// Initiliaze the protected variables
		m_Body = new Body();
		m_Name = "BroadcastGlobal";
		
		/// Copy the values
		m_Body = value.m_Body;
	}
	
}
