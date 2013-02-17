package src.urn_TestCOPServiceDef_1_0.Messages;

import framework.messages.Message;
import framework.JausUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetWrenchEffort extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x0405;
	
	public static class  AppHeader
	{
		public static class  HeaderRec
		{
		
			protected AppHeader m_parent;
			protected int m_MessageID;
		
			public void setParent(AppHeader parent)
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
			
			public int getMessageID()
			{
				return m_MessageID;
			}
			
			public void setMessageID(int value)
			{
				m_MessageID = value;
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
				
				size += JausUtils.getNumBytes("short");
				
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
				
				bytes.putShort(pos, (short) m_MessageID);
				pos += JausUtils.getNumBytes("short");
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
				
				m_MessageID = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
			}
			
			public SetWrenchEffort.AppHeader.HeaderRec assign(HeaderRec value)
			{
				m_MessageID = value.m_MessageID;
				
				return this;
			}
			
			public boolean isEqual(HeaderRec value)
			{
				if (m_MessageID != value.getMessageID())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(HeaderRec value)
			{
				return !this.isEqual(value);
			}
			
			public HeaderRec()
			{
				m_parent = null;
				m_MessageID = 0x0405;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x0405;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public SetWrenchEffort.AppHeader.HeaderRec getHeaderRec()
		{
			return m_HeaderRec;
		}
		
		public void setHeaderRec(HeaderRec value)
		{
			m_HeaderRec = value;
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
			
			size += m_HeaderRec.getSize();
			
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
			
			m_HeaderRec.encode(bytes, pos);
			pos += m_HeaderRec.getSize();
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
			
			m_HeaderRec.decode(bytes, pos);
			pos += m_HeaderRec.getSize();
		}
		
		public SetWrenchEffort.AppHeader assign(AppHeader value)
		{
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
			
			return this;
		}
		
		public boolean isEqual(AppHeader value)
		{
			if (!m_HeaderRec.isEqual(value.getHeaderRec()))
			{
				return false;
			}
			return true;
		}
		
		public boolean notEquals(AppHeader value)
		{
			return !this.isEqual(value);
		}
		
		public AppHeader()
		{
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
		}
		
		public AppHeader(AppHeader value)
		{
			/// Initiliaze the protected variables
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
			
			/// Copy the values
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
		}
		
		public void finalize()
		{
		}
		
	}
	public static class  Body
	{
		public static class  WrenchEffortRec
		{
		
			protected Body m_parent;
			protected BitSet m_PresenceVector;
			protected int m_PresenceVectorTemp;
			protected int m_PropulsiveLinearEffortX;
			protected int m_PropulsiveLinearEffortY;
			protected int m_PropulsiveLinearEffortZ;
			protected int m_PropulsiveRotationalEffortX;
			protected int m_PropulsiveRotationalEffortY;
			protected int m_PropulsiveRotationalEffortZ;
			protected short m_ResistiveLinearEffortX;
			protected short m_ResistiveLinearEffortY;
			protected short m_ResistiveLinearEffortZ;
			protected short m_ResistiveRotationalEffortX;
			protected short m_ResistiveRotationalEffortY;
			protected short m_ResistiveRotationalEffortZ;
		
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
			
			public int getPresenceVector()
			{
				return m_PresenceVectorTemp;
			}
			
			protected void setPresenceVector(int index)
			{
				
				m_PresenceVector.set(index);
				m_PresenceVectorTemp = (int) JausUtils.getPVInt(m_PresenceVector);
			}
			
			public boolean checkPresenceVector(int index)
			{
				
				return m_PresenceVector.get(index);
			}
			
			public boolean isPropulsiveLinearEffortXValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public double getPropulsiveLinearEffortX()
			{
				double value;
				
				double scaleFactor = ( 100 - -100 ) / 65535.0;
				double bias = -100;
				
				value = m_PropulsiveLinearEffortX * scaleFactor + bias;
				
				return value;
			}
			
			public void setPropulsiveLinearEffortX(double value)
			{
				if ((value >= -100) && (value <= 100))
				{
					double scaleFactor = ( 100 - -100 ) / 65535.0;
					double bias = -100;
					
					m_PropulsiveLinearEffortX= (int)((value - bias) / scaleFactor);
					setPresenceVector(0);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPropulsiveLinearEffortYValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public double getPropulsiveLinearEffortY()
			{
				double value;
				
				double scaleFactor = ( 100 - -100 ) / 65535.0;
				double bias = -100;
				
				value = m_PropulsiveLinearEffortY * scaleFactor + bias;
				
				return value;
			}
			
			public void setPropulsiveLinearEffortY(double value)
			{
				if ((value >= -100) && (value <= 100))
				{
					double scaleFactor = ( 100 - -100 ) / 65535.0;
					double bias = -100;
					
					m_PropulsiveLinearEffortY= (int)((value - bias) / scaleFactor);
					setPresenceVector(1);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPropulsiveLinearEffortZValid()
			{
				if (checkPresenceVector(2))
				{
					return true;
				}
				return false;
			}
			
			public double getPropulsiveLinearEffortZ()
			{
				double value;
				
				double scaleFactor = ( 100 - -100 ) / 65535.0;
				double bias = -100;
				
				value = m_PropulsiveLinearEffortZ * scaleFactor + bias;
				
				return value;
			}
			
			public void setPropulsiveLinearEffortZ(double value)
			{
				if ((value >= -100) && (value <= 100))
				{
					double scaleFactor = ( 100 - -100 ) / 65535.0;
					double bias = -100;
					
					m_PropulsiveLinearEffortZ= (int)((value - bias) / scaleFactor);
					setPresenceVector(2);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPropulsiveRotationalEffortXValid()
			{
				if (checkPresenceVector(3))
				{
					return true;
				}
				return false;
			}
			
			public double getPropulsiveRotationalEffortX()
			{
				double value;
				
				double scaleFactor = ( 100 - -100 ) / 65535.0;
				double bias = -100;
				
				value = m_PropulsiveRotationalEffortX * scaleFactor + bias;
				
				return value;
			}
			
			public void setPropulsiveRotationalEffortX(double value)
			{
				if ((value >= -100) && (value <= 100))
				{
					double scaleFactor = ( 100 - -100 ) / 65535.0;
					double bias = -100;
					
					m_PropulsiveRotationalEffortX= (int)((value - bias) / scaleFactor);
					setPresenceVector(3);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPropulsiveRotationalEffortYValid()
			{
				if (checkPresenceVector(4))
				{
					return true;
				}
				return false;
			}
			
			public double getPropulsiveRotationalEffortY()
			{
				double value;
				
				double scaleFactor = ( 100 - -100 ) / 65535.0;
				double bias = -100;
				
				value = m_PropulsiveRotationalEffortY * scaleFactor + bias;
				
				return value;
			}
			
			public void setPropulsiveRotationalEffortY(double value)
			{
				if ((value >= -100) && (value <= 100))
				{
					double scaleFactor = ( 100 - -100 ) / 65535.0;
					double bias = -100;
					
					m_PropulsiveRotationalEffortY= (int)((value - bias) / scaleFactor);
					setPresenceVector(4);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPropulsiveRotationalEffortZValid()
			{
				if (checkPresenceVector(5))
				{
					return true;
				}
				return false;
			}
			
			public double getPropulsiveRotationalEffortZ()
			{
				double value;
				
				double scaleFactor = ( 100 - -100 ) / 65535.0;
				double bias = -100;
				
				value = m_PropulsiveRotationalEffortZ * scaleFactor + bias;
				
				return value;
			}
			
			public void setPropulsiveRotationalEffortZ(double value)
			{
				if ((value >= -100) && (value <= 100))
				{
					double scaleFactor = ( 100 - -100 ) / 65535.0;
					double bias = -100;
					
					m_PropulsiveRotationalEffortZ= (int)((value - bias) / scaleFactor);
					setPresenceVector(5);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isResistiveLinearEffortXValid()
			{
				if (checkPresenceVector(6))
				{
					return true;
				}
				return false;
			}
			
			public double getResistiveLinearEffortX()
			{
				double value;
				
				double scaleFactor = ( 100 - 0 ) / 255.0;
				double bias = 0;
				
				value = m_ResistiveLinearEffortX * scaleFactor + bias;
				
				return value;
			}
			
			public void setResistiveLinearEffortX(double value)
			{
				if ((value >= 0) && (value <= 100))
				{
					double scaleFactor = ( 100 - 0 ) / 255.0;
					double bias = 0;
					
					m_ResistiveLinearEffortX= (short)((value - bias) / scaleFactor);
					setPresenceVector(6);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isResistiveLinearEffortYValid()
			{
				if (checkPresenceVector(7))
				{
					return true;
				}
				return false;
			}
			
			public double getResistiveLinearEffortY()
			{
				double value;
				
				double scaleFactor = ( 100 - 0 ) / 255.0;
				double bias = 0;
				
				value = m_ResistiveLinearEffortY * scaleFactor + bias;
				
				return value;
			}
			
			public void setResistiveLinearEffortY(double value)
			{
				if ((value >= 0) && (value <= 100))
				{
					double scaleFactor = ( 100 - 0 ) / 255.0;
					double bias = 0;
					
					m_ResistiveLinearEffortY= (short)((value - bias) / scaleFactor);
					setPresenceVector(7);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isResistiveLinearEffortZValid()
			{
				if (checkPresenceVector(8))
				{
					return true;
				}
				return false;
			}
			
			public double getResistiveLinearEffortZ()
			{
				double value;
				
				double scaleFactor = ( 100 - 0 ) / 255.0;
				double bias = 0;
				
				value = m_ResistiveLinearEffortZ * scaleFactor + bias;
				
				return value;
			}
			
			public void setResistiveLinearEffortZ(double value)
			{
				if ((value >= 0) && (value <= 100))
				{
					double scaleFactor = ( 100 - 0 ) / 255.0;
					double bias = 0;
					
					m_ResistiveLinearEffortZ= (short)((value - bias) / scaleFactor);
					setPresenceVector(8);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isResistiveRotationalEffortXValid()
			{
				if (checkPresenceVector(9))
				{
					return true;
				}
				return false;
			}
			
			public double getResistiveRotationalEffortX()
			{
				double value;
				
				double scaleFactor = ( 100 - 0 ) / 255.0;
				double bias = 0;
				
				value = m_ResistiveRotationalEffortX * scaleFactor + bias;
				
				return value;
			}
			
			public void setResistiveRotationalEffortX(double value)
			{
				if ((value >= 0) && (value <= 100))
				{
					double scaleFactor = ( 100 - 0 ) / 255.0;
					double bias = 0;
					
					m_ResistiveRotationalEffortX= (short)((value - bias) / scaleFactor);
					setPresenceVector(9);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isResistiveRotationalEffortYValid()
			{
				if (checkPresenceVector(10))
				{
					return true;
				}
				return false;
			}
			
			public double getResistiveRotationalEffortY()
			{
				double value;
				
				double scaleFactor = ( 100 - 0 ) / 255.0;
				double bias = 0;
				
				value = m_ResistiveRotationalEffortY * scaleFactor + bias;
				
				return value;
			}
			
			public void setResistiveRotationalEffortY(double value)
			{
				if ((value >= 0) && (value <= 100))
				{
					double scaleFactor = ( 100 - 0 ) / 255.0;
					double bias = 0;
					
					m_ResistiveRotationalEffortY= (short)((value - bias) / scaleFactor);
					setPresenceVector(10);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isResistiveRotationalEffortZValid()
			{
				if (checkPresenceVector(11))
				{
					return true;
				}
				return false;
			}
			
			public double getResistiveRotationalEffortZ()
			{
				double value;
				
				double scaleFactor = ( 100 - 0 ) / 255.0;
				double bias = 0;
				
				value = m_ResistiveRotationalEffortZ * scaleFactor + bias;
				
				return value;
			}
			
			public void setResistiveRotationalEffortZ(double value)
			{
				if ((value >= 0) && (value <= 100))
				{
					double scaleFactor = ( 100 - 0 ) / 255.0;
					double bias = 0;
					
					m_ResistiveRotationalEffortZ= (short)((value - bias) / scaleFactor);
					setPresenceVector(11);
					setParentPresenceVector();
				}
				return;
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
				
				size += JausUtils.getNumBytes("short");
				if (checkPresenceVector(0))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(1))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(3))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(4))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(5))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(6))
				{
					size += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(7))
				{
					size += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(8))
				{
					size += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(9))
				{
					size += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(10))
				{
					size += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(11))
				{
					size += JausUtils.getNumBytes("byte");
				}
				
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
					int m_PresenceVectorTemp = (int) JausUtils.getPVInt(m_PresenceVector);
				bytes.putShort(pos, (short) m_PresenceVectorTemp);
				pos += JausUtils.getNumBytes("short");
				}
				catch(Exception e)
				{
					logger.log(Level.SEVERE, null, e);
				}
				if (checkPresenceVector(0))
				{
					bytes.putShort(pos, (short) m_PropulsiveLinearEffortX);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(1))
				{
					bytes.putShort(pos, (short) m_PropulsiveLinearEffortY);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					bytes.putShort(pos, (short) m_PropulsiveLinearEffortZ);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(3))
				{
					bytes.putShort(pos, (short) m_PropulsiveRotationalEffortX);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(4))
				{
					bytes.putShort(pos, (short) m_PropulsiveRotationalEffortY);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(5))
				{
					bytes.putShort(pos, (short) m_PropulsiveRotationalEffortZ);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(6))
				{
					bytes.put(pos, (byte) m_ResistiveLinearEffortX);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(7))
				{
					bytes.put(pos, (byte) m_ResistiveLinearEffortY);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(8))
				{
					bytes.put(pos, (byte) m_ResistiveLinearEffortZ);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(9))
				{
					bytes.put(pos, (byte) m_ResistiveRotationalEffortX);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(10))
				{
					bytes.put(pos, (byte) m_ResistiveRotationalEffortY);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(11))
				{
					bytes.put(pos, (byte) m_ResistiveRotationalEffortZ);
					pos += JausUtils.getNumBytes("byte");
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
				
				try
				{
					int m_PresenceVectorTemp = 0;
				m_PresenceVectorTemp = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_PresenceVector = JausUtils.setPV(m_PresenceVectorTemp);
				}
				catch(Exception e)
				{
					logger.log(Level.SEVERE, null, e);
				}
				if (checkPresenceVector(0))
				{
					m_PropulsiveLinearEffortX = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(1))
				{
					m_PropulsiveLinearEffortY = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					m_PropulsiveLinearEffortZ = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(3))
				{
					m_PropulsiveRotationalEffortX = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(4))
				{
					m_PropulsiveRotationalEffortY = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(5))
				{
					m_PropulsiveRotationalEffortZ = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(6))
				{
					m_ResistiveLinearEffortX = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(7))
				{
					m_ResistiveLinearEffortY = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(8))
				{
					m_ResistiveLinearEffortZ = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(9))
				{
					m_ResistiveRotationalEffortX = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(10))
				{
					m_ResistiveRotationalEffortY = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				if (checkPresenceVector(11))
				{
					m_ResistiveRotationalEffortZ = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
			}
			
			public SetWrenchEffort.Body.WrenchEffortRec assign(WrenchEffortRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_PropulsiveLinearEffortX = value.m_PropulsiveLinearEffortX;
				m_PropulsiveLinearEffortY = value.m_PropulsiveLinearEffortY;
				m_PropulsiveLinearEffortZ = value.m_PropulsiveLinearEffortZ;
				m_PropulsiveRotationalEffortX = value.m_PropulsiveRotationalEffortX;
				m_PropulsiveRotationalEffortY = value.m_PropulsiveRotationalEffortY;
				m_PropulsiveRotationalEffortZ = value.m_PropulsiveRotationalEffortZ;
				m_ResistiveLinearEffortX = value.m_ResistiveLinearEffortX;
				m_ResistiveLinearEffortY = value.m_ResistiveLinearEffortY;
				m_ResistiveLinearEffortZ = value.m_ResistiveLinearEffortZ;
				m_ResistiveRotationalEffortX = value.m_ResistiveRotationalEffortX;
				m_ResistiveRotationalEffortY = value.m_ResistiveRotationalEffortY;
				m_ResistiveRotationalEffortZ = value.m_ResistiveRotationalEffortZ;
				
				return this;
			}
			
			public boolean isEqual(WrenchEffortRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_PropulsiveLinearEffortX != value.getPropulsiveLinearEffortX())
				{
					return false;
				}
				if (m_PropulsiveLinearEffortY != value.getPropulsiveLinearEffortY())
				{
					return false;
				}
				if (m_PropulsiveLinearEffortZ != value.getPropulsiveLinearEffortZ())
				{
					return false;
				}
				if (m_PropulsiveRotationalEffortX != value.getPropulsiveRotationalEffortX())
				{
					return false;
				}
				if (m_PropulsiveRotationalEffortY != value.getPropulsiveRotationalEffortY())
				{
					return false;
				}
				if (m_PropulsiveRotationalEffortZ != value.getPropulsiveRotationalEffortZ())
				{
					return false;
				}
				if (m_ResistiveLinearEffortX != value.getResistiveLinearEffortX())
				{
					return false;
				}
				if (m_ResistiveLinearEffortY != value.getResistiveLinearEffortY())
				{
					return false;
				}
				if (m_ResistiveLinearEffortZ != value.getResistiveLinearEffortZ())
				{
					return false;
				}
				if (m_ResistiveRotationalEffortX != value.getResistiveRotationalEffortX())
				{
					return false;
				}
				if (m_ResistiveRotationalEffortY != value.getResistiveRotationalEffortY())
				{
					return false;
				}
				if (m_ResistiveRotationalEffortZ != value.getResistiveRotationalEffortZ())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(WrenchEffortRec value)
			{
				return !this.isEqual(value);
			}
			
			public WrenchEffortRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_PropulsiveLinearEffortX = 0;
				m_PropulsiveLinearEffortY = 0;
				m_PropulsiveLinearEffortZ = 0;
				m_PropulsiveRotationalEffortX = 0;
				m_PropulsiveRotationalEffortY = 0;
				m_PropulsiveRotationalEffortZ = 0;
				m_ResistiveLinearEffortX = 0;
				m_ResistiveLinearEffortY = 0;
				m_ResistiveLinearEffortZ = 0;
				m_ResistiveRotationalEffortX = 0;
				m_ResistiveRotationalEffortY = 0;
				m_ResistiveRotationalEffortZ = 0;
			}
			
			public WrenchEffortRec(WrenchEffortRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_PropulsiveLinearEffortX = 0;
				m_PropulsiveLinearEffortY = 0;
				m_PropulsiveLinearEffortZ = 0;
				m_PropulsiveRotationalEffortX = 0;
				m_PropulsiveRotationalEffortY = 0;
				m_PropulsiveRotationalEffortZ = 0;
				m_ResistiveLinearEffortX = 0;
				m_ResistiveLinearEffortY = 0;
				m_ResistiveLinearEffortZ = 0;
				m_ResistiveRotationalEffortX = 0;
				m_ResistiveRotationalEffortY = 0;
				m_ResistiveRotationalEffortZ = 0;
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_PropulsiveLinearEffortX = value.m_PropulsiveLinearEffortX;
				m_PropulsiveLinearEffortY = value.m_PropulsiveLinearEffortY;
				m_PropulsiveLinearEffortZ = value.m_PropulsiveLinearEffortZ;
				m_PropulsiveRotationalEffortX = value.m_PropulsiveRotationalEffortX;
				m_PropulsiveRotationalEffortY = value.m_PropulsiveRotationalEffortY;
				m_PropulsiveRotationalEffortZ = value.m_PropulsiveRotationalEffortZ;
				m_ResistiveLinearEffortX = value.m_ResistiveLinearEffortX;
				m_ResistiveLinearEffortY = value.m_ResistiveLinearEffortY;
				m_ResistiveLinearEffortZ = value.m_ResistiveLinearEffortZ;
				m_ResistiveRotationalEffortX = value.m_ResistiveRotationalEffortX;
				m_ResistiveRotationalEffortY = value.m_ResistiveRotationalEffortY;
				m_ResistiveRotationalEffortZ = value.m_ResistiveRotationalEffortZ;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected WrenchEffortRec m_WrenchEffortRec;
	
		public SetWrenchEffort.Body.WrenchEffortRec getWrenchEffortRec()
		{
			return m_WrenchEffortRec;
		}
		
		public void setWrenchEffortRec(WrenchEffortRec value)
		{
			m_WrenchEffortRec = value;
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
			
			size += m_WrenchEffortRec.getSize();
			
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
			
			m_WrenchEffortRec.encode(bytes, pos);
			pos += m_WrenchEffortRec.getSize();
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
			
			m_WrenchEffortRec.decode(bytes, pos);
			pos += m_WrenchEffortRec.getSize();
		}
		
		public SetWrenchEffort.Body assign(Body value)
		{
			m_WrenchEffortRec = value.m_WrenchEffortRec;
			m_WrenchEffortRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_WrenchEffortRec.isEqual(value.getWrenchEffortRec()))
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
			m_WrenchEffortRec = new WrenchEffortRec();
			m_WrenchEffortRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_WrenchEffortRec = new WrenchEffortRec();
			m_WrenchEffortRec.setParent(this);
			
			/// Copy the values
			m_WrenchEffortRec = value.m_WrenchEffortRec;
			m_WrenchEffortRec.setParent(this);
			/// This code is currently not supported
		}
		
		public void finalize()
		{
		}
		
	}
	protected AppHeader m_AppHeader;
	protected Body m_Body;
	public long getID()
	{
	return ID;
 }
	public SetWrenchEffort.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public SetWrenchEffort.Body getBody()
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
		
		size += m_AppHeader.getSize();
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
		
		m_AppHeader.encode(bytes, pos);
		pos += m_AppHeader.getSize();
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
		
		m_AppHeader.decode(bytes, pos);
		pos += m_AppHeader.getSize();
		m_Body.decode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public SetWrenchEffort setAs(SetWrenchEffort value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(SetWrenchEffort value)
	{
		if (!m_AppHeader.isEqual(value.getAppHeader()))
		{
			return false;
		}
		if (!m_Body.isEqual(value.getBody()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean notEquals(SetWrenchEffort value)
	{
		return !isEqual(value);
	}
	
	public SetWrenchEffort()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
	}
	
	public  SetWrenchEffort(SetWrenchEffort value)
	{
		/// Initiliaze the protected variables
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
		
		/// Copy the values
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
	}
	
}
