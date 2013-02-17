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

public class ReportAnalogVideoSensorCapabilities extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4810;
	
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
			
			public ReportAnalogVideoSensorCapabilities.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4810;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4810;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportAnalogVideoSensorCapabilities.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportAnalogVideoSensorCapabilities.AppHeader assign(AppHeader value)
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
		public static class  AnalogVideoSensorCapabilitiesList
		{
			public static class  AnalogVideoSensorCapabilitiesRec
			{
				public static class  SupportedAnalogFormats
				{
				
					protected AnalogVideoSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(AnalogVideoSensorCapabilitiesRec parent)
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
					
					public short getNTSCM()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setNTSCM(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getNTSCJ()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setNTSCJ(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getPALN()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setPALN(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getPALM()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 3; index <= 3; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setPALM(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 3; index <= 3; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getSECAML()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 4; index <= 4; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setSECAML(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 4; index <= 4; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getSECAMBG()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 5; index <= 5; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setSECAMBG(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 5; index <= 5; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
						pos += JausUtils.getNumBytes("byte");
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportAnalogVideoSensorCapabilities.Body.AnalogVideoSensorCapabilitiesList.AnalogVideoSensorCapabilitiesRec.SupportedAnalogFormats assign(SupportedAnalogFormats value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(SupportedAnalogFormats value)
					{
						return this.m_SubFields == value.getSECAMBG();
					}
					
					public boolean notEquals(SupportedAnalogFormats value)
					{
						return !this.isEqual(value);
					}
					
					public SupportedAnalogFormats()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public SupportedAnalogFormats(SupportedAnalogFormats value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected AnalogVideoSensorCapabilitiesList m_parent;
				protected int m_SensorID;
				protected SupportedAnalogFormats m_SupportedAnalogFormats;
			
				public void setParent(AnalogVideoSensorCapabilitiesList parent)
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
				
				public int getSensorID()
				{
					return m_SensorID;
				}
				
				public void setSensorID(int value)
				{
					m_SensorID = value;
					setParentPresenceVector();
				}
				
				public ReportAnalogVideoSensorCapabilities.Body.AnalogVideoSensorCapabilitiesList.AnalogVideoSensorCapabilitiesRec.SupportedAnalogFormats getSupportedAnalogFormats()
				{
					return m_SupportedAnalogFormats;
				}
				
				public void setSupportedAnalogFormats(SupportedAnalogFormats value)
				{
					m_SupportedAnalogFormats = value;
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
					size += m_SupportedAnalogFormats.getSize();
					
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
					
					bytes.putShort(pos, (short) m_SensorID);
					pos += JausUtils.getNumBytes("short");
					m_SupportedAnalogFormats.encode(bytes, pos);
					pos += m_SupportedAnalogFormats.getSize();
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
					
					m_SensorID = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
					m_SupportedAnalogFormats.decode(bytes, pos);
					pos += m_SupportedAnalogFormats.getSize();
				}
				
				public ReportAnalogVideoSensorCapabilities.Body.AnalogVideoSensorCapabilitiesList.AnalogVideoSensorCapabilitiesRec assign(AnalogVideoSensorCapabilitiesRec value)
				{
					m_SensorID = value.m_SensorID;
					m_SupportedAnalogFormats = value.m_SupportedAnalogFormats;
					
					return this;
				}
				
				public boolean isEqual(AnalogVideoSensorCapabilitiesRec value)
				{
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					
					if (!m_SupportedAnalogFormats.isEqual(value.getSupportedAnalogFormats()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(AnalogVideoSensorCapabilitiesRec value)
				{
					return !this.isEqual(value);
				}
				
				public AnalogVideoSensorCapabilitiesRec()
				{
					m_parent = null;
					m_SensorID = 0;
					m_SupportedAnalogFormats = new SupportedAnalogFormats();
					m_SupportedAnalogFormats.setParent(this);
				}
				
				public AnalogVideoSensorCapabilitiesRec(AnalogVideoSensorCapabilitiesRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_SensorID = 0;
					m_SupportedAnalogFormats = new SupportedAnalogFormats();
					m_SupportedAnalogFormats.setParent(this);
					
					/// Copy the values
					m_SensorID = value.m_SensorID;
					m_SupportedAnalogFormats = value.m_SupportedAnalogFormats;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<AnalogVideoSensorCapabilitiesRec> m_AnalogVideoSensorCapabilitiesRec;
		
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
			
			public long getNumberOfElements()
			{
				return (long) m_AnalogVideoSensorCapabilitiesRec.size();
			}
			
			public ReportAnalogVideoSensorCapabilities.Body.AnalogVideoSensorCapabilitiesList.AnalogVideoSensorCapabilitiesRec getElement(int index)
			{
				return m_AnalogVideoSensorCapabilitiesRec.get(index);
			}
			
			public void setElement(int index, AnalogVideoSensorCapabilitiesRec value)
			{
				if(m_AnalogVideoSensorCapabilitiesRec.size()-1 < index)
				{
					return;
				}
				
				m_AnalogVideoSensorCapabilitiesRec.set(index, value);
				m_AnalogVideoSensorCapabilitiesRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(AnalogVideoSensorCapabilitiesRec value)
			{
				m_AnalogVideoSensorCapabilitiesRec.add(value);
				m_AnalogVideoSensorCapabilitiesRec.get(m_AnalogVideoSensorCapabilitiesRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_AnalogVideoSensorCapabilitiesRec.size()-1 < index)
				{
					return 1;
				}
				
				m_AnalogVideoSensorCapabilitiesRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_AnalogVideoSensorCapabilitiesRec.remove(m_AnalogVideoSensorCapabilitiesRec.size()-1);
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
				long size = 0;
				
				size += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_AnalogVideoSensorCapabilitiesRec.size(); i++)
				{
					size += m_AnalogVideoSensorCapabilitiesRec.get(i).getSize();
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
				
				int size = (int) m_AnalogVideoSensorCapabilitiesRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_AnalogVideoSensorCapabilitiesRec.size(); i++)
				{
					m_AnalogVideoSensorCapabilitiesRec.get(i).encode(bytes, pos);
					pos += m_AnalogVideoSensorCapabilitiesRec.get(i).getSize();
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
				
				int size;
				size = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_AnalogVideoSensorCapabilitiesRec = new ArrayList<AnalogVideoSensorCapabilitiesRec>();
				for (int i = 0; i <  size; i++)
				{
					AnalogVideoSensorCapabilitiesRec item = new AnalogVideoSensorCapabilitiesRec();
					item.decode(bytes, pos);
					m_AnalogVideoSensorCapabilitiesRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportAnalogVideoSensorCapabilities.Body.AnalogVideoSensorCapabilitiesList assign(AnalogVideoSensorCapabilitiesList value)
			{
				m_AnalogVideoSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_AnalogVideoSensorCapabilitiesRec.size(); i++)
				{
					m_AnalogVideoSensorCapabilitiesRec.add(value.m_AnalogVideoSensorCapabilitiesRec.get(i));
					m_AnalogVideoSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(AnalogVideoSensorCapabilitiesList value)
			{
				for (int i = 0; i < m_AnalogVideoSensorCapabilitiesRec.size(); i++)
				{
					if (!m_AnalogVideoSensorCapabilitiesRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(AnalogVideoSensorCapabilitiesList value)
			{
				return !this.isEqual(value);
			}
			
			public AnalogVideoSensorCapabilitiesList()
			{
				m_parent = null;
				m_AnalogVideoSensorCapabilitiesRec = new ArrayList<AnalogVideoSensorCapabilitiesRec>();
				for (int i = 0; i < m_AnalogVideoSensorCapabilitiesRec.size(); i++)
				{
					m_AnalogVideoSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public AnalogVideoSensorCapabilitiesList(AnalogVideoSensorCapabilitiesList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_AnalogVideoSensorCapabilitiesRec = new ArrayList<AnalogVideoSensorCapabilitiesRec>();
				for (int i = 0; i < m_AnalogVideoSensorCapabilitiesRec.size(); i++)
				{
					m_AnalogVideoSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_AnalogVideoSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_AnalogVideoSensorCapabilitiesRec.size(); i++)
				{
					m_AnalogVideoSensorCapabilitiesRec.add(value.m_AnalogVideoSensorCapabilitiesRec.get(i));
					m_AnalogVideoSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected AnalogVideoSensorCapabilitiesList m_AnalogVideoSensorCapabilitiesList;
	
		public ReportAnalogVideoSensorCapabilities.Body.AnalogVideoSensorCapabilitiesList getAnalogVideoSensorCapabilitiesList()
		{
			return m_AnalogVideoSensorCapabilitiesList;
		}
		
		public void setAnalogVideoSensorCapabilitiesList(AnalogVideoSensorCapabilitiesList value)
		{
			m_AnalogVideoSensorCapabilitiesList = value;
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
			
			size += m_AnalogVideoSensorCapabilitiesList.getSize();
			
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
			
			m_AnalogVideoSensorCapabilitiesList.encode(bytes, pos);
			pos += m_AnalogVideoSensorCapabilitiesList.getSize();
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
			
			m_AnalogVideoSensorCapabilitiesList.decode(bytes, pos);
			pos += m_AnalogVideoSensorCapabilitiesList.getSize();
		}
		
		public ReportAnalogVideoSensorCapabilities.Body assign(Body value)
		{
			m_AnalogVideoSensorCapabilitiesList = value.m_AnalogVideoSensorCapabilitiesList;
			m_AnalogVideoSensorCapabilitiesList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_AnalogVideoSensorCapabilitiesList.isEqual(value.m_AnalogVideoSensorCapabilitiesList))
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
			m_AnalogVideoSensorCapabilitiesList = new AnalogVideoSensorCapabilitiesList();
			m_AnalogVideoSensorCapabilitiesList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_AnalogVideoSensorCapabilitiesList = new AnalogVideoSensorCapabilitiesList();
			m_AnalogVideoSensorCapabilitiesList.setParent(this);
			
			/// Copy the values
			m_AnalogVideoSensorCapabilitiesList = value.m_AnalogVideoSensorCapabilitiesList;
			m_AnalogVideoSensorCapabilitiesList.setParent(this);
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
	public ReportAnalogVideoSensorCapabilities.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportAnalogVideoSensorCapabilities.Body getBody()
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
	
	public ReportAnalogVideoSensorCapabilities setAs(ReportAnalogVideoSensorCapabilities value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportAnalogVideoSensorCapabilities value)
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
	
	public boolean notEquals(ReportAnalogVideoSensorCapabilities value)
	{
		return !isEqual(value);
	}
	
	public ReportAnalogVideoSensorCapabilities()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportAnalogVideoSensorCapabilities(ReportAnalogVideoSensorCapabilities value)
	{
		/// Initiliaze the protected variables
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
		
		/// Copy the values
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
	}
	
}
